package com.sxx.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.Category;
import com.sxx.product.mapper.CategoryMapper;
import com.sxx.product.service.CategoryService;
import com.sxx.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 针对表【pms_category(商品三级分类)】的数据库操作Service实现
 *
 * @author shenxianxin
 * @since 2021-12-02 18:42:19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {


    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * 查询商品品类
     *
     * @return 品类结果集并按三级列表返回
     */
    @Override
    public List<Category> listWithTree() {
        List<Category> categoryList = baseMapper.selectList(null);
        return categoryList.stream().filter(category -> category.getParentCid() == 0)
                .peek(category -> category.setChildList(getChildList(category.getCatId(), categoryList)))
                .sorted(Comparator.comparingInt(menuOne -> (menuOne.getSort() != null ? menuOne.getSort() : 0)))
                .collect(Collectors.toList());
    }

    /**
     * 根据ids删除菜单
     *
     * @param ids id 集合
     */
    @Override
    public void deleteMenusByIds(Long[] ids) {
        //TODO 关联删除校验
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 根据categoryID查询详细信息进行回写
     *
     * @param categoryId ID
     * @return 回写分组详细信息
     */
    @Override
    public Long[] findCategoryPathById(Long categoryId) {
        List<Long> list = new ArrayList<>(4);
        recursionGetCategoryId(categoryId, list);
        Collections.reverse(list);
        return list.toArray(new Long[list.size() - 1]);
    }

    /**
     * 每一个需要缓存的数据我们都来指定要放到那个名字的缓存。【缓存的分区(按照业务类型分)】
     * 代表当前方法的结果需要缓存，如果缓存中有，方法都不用调用，如果缓存中没有，会调用方法。最后将方法的结果放入缓存
     * 默认行为
     *      如果缓存中有，方法不再调用
     *      key是默认生成的:缓存的名字::SimpleKey::[](自动生成key值)
     *      缓存的value值，默认使用jdk序列化机制，将序列化的数据存到redis中
     *      默认时间是 -1：
     *
     *   自定义操作：key的生成
     *      指定生成缓存的key：key属性指定，接收一个Spel
     *      指定缓存的数据的存活时间:配置文档中修改存活时间
     *      将数据保存为json格式
     *
     *
     * 4、Spring-Cache的不足之处：
     *  1）、读模式
     *      缓存穿透：查询一个null数据。解决方案：缓存空数据
     *      缓存击穿：大量并发进来同时查询一个正好过期的数据。解决方案：加锁 ? 默认是无加锁的;使用sync = true来解决击穿问题
     *      缓存雪崩：大量的key同时过期。解决：加随机时间。加上过期时间
     *  2)、写模式：（缓存与数据库一致）
     *      1）、读写加锁。
     *      2）、引入Canal,感知到MySQL的更新去更新Redis
     *      3）、读多写多，直接去数据库查询就行
     *
     *  总结：
     *      常规数据（读多写少，即时性，一致性要求不高的数据，完全可以使用Spring-Cache）：写模式(只要缓存的数据有过期时间就足够了)
     *      特殊数据：特殊设计
     *
     *  原理：
     *      CacheManager(RedisCacheManager)->Cache(RedisCache)->Cache负责缓存的读写
     * @return
     */
    @Cacheable(value = {"category"},key = "#root.method.name",sync = true)
    @Override
    public List<Category> getLevel1Categorys() {
        long l = System.currentTimeMillis();
        List<Category> categoryEntities = this.baseMapper.selectList(
                new QueryWrapper<Category>().eq("parent_cid", 0));
        System.out.println("消耗时间："+ (System.currentTimeMillis() - l));
        return categoryEntities;
    }


    @Cacheable(value = "category",key = "#root.methodName")
    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJson() {

        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 300, TimeUnit.SECONDS);
        String catalogJson = redisTemplate.opsForValue().get("catalogJson");
        if (!StringUtils.isEmpty(catalogJson)) {
            System.out.println("cache");
            return JSON.parseObject(catalogJson, new TypeReference<Map<String, List<Catelog2Vo>>>() {
            });
        }
        Map<String, List<Catelog2Vo>> parentCid = null;
        if (Boolean.TRUE.equals(lock)) {
            try {
                //将数据库的多次查询变为一次
                List<Category> selectList = this.baseMapper.selectList(null);

                //1、查出所有分类
                //1、1）查出所有一级分类
                List<Category> level1Categorys = getParent_cid(selectList, 0L);

                //封装数据
                parentCid = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
                   //1、每一个的一级分类,查到这个一级分类的二级分类
                   List<Category> categoryEntities = getParent_cid(selectList, v.getCatId());

                   //2、封装上面的结果
                   List<Catelog2Vo> catelog2Vos = new ArrayList<>();
                   if (categoryEntities != null) {
                       catelog2Vos = categoryEntities.stream().map(l2 -> {
                           Catelog2Vo catelog2Vo = new Catelog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName().toString());

                           //1、找当前二级分类的三级分类封装成vo
                           List<Category> level3Catelog = getParent_cid(selectList, l2.getCatId());

                           if (level3Catelog != null) {
                               List<Catelog2Vo.Category3Vo> category3Vos = level3Catelog.stream().map(l3 -> {
                                   //2、封装成指定格式
                                   return new Catelog2Vo.Category3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                               }).collect(Collectors.toList());
                               catelog2Vo.setCatalog3List(category3Vos);
                           }

                           return catelog2Vo;
                       }).collect(Collectors.toList());
                   }
                    return catelog2Vos;
               }));
            } finally {
                String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                //删除锁
                redisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Collections.singletonList("lock"), uuid);            }
        }
        if (Boolean.FALSE.equals(lock)) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("sleep...");
            }
            getCatalogJson();
        }
        return parentCid;
    }


    /**
     * 查询category 所有父子id
     *
     * @param categoryId 当前分组id
     * @param list       当前分组id 的所有父子 id
     */
    private void recursionGetCategoryId(Long categoryId, List<Long> list) {
        list.add(categoryId);
        Category category = this.getById(categoryId);
        if (category.getParentCid() != 0 && category.getParentCid() > 0 && category.getParentCid() != null) {
            recursionGetCategoryId(category.getParentCid(), list);
        }
    }

    /**
     * 递归查询品类子类
     *
     * @param catId        品类 id
     * @param categoryList 总类列表
     * @return 子类列表
     */
    private List<Category> getChildList(Long catId, List<Category> categoryList) {
        return categoryList.stream().filter(category -> category.getParentCid().equals(catId))
                .peek(category -> category.setChildList(getChildList(category.getCatId(), categoryList)))
                .sorted(Comparator.comparingInt(menuOne -> (menuOne.getSort() != null ? menuOne.getSort() : 0)))
                .collect(Collectors.toList());
    }

    private List<Category> getParent_cid(List<Category> selectList,Long parentCid) {
        return selectList.stream().filter(item -> item.getParentCid().equals(parentCid)).collect(Collectors.toList());
    }

}




