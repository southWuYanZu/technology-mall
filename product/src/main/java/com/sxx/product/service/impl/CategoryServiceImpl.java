package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.Category;
import com.sxx.product.service.CategoryService;
import com.sxx.product.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenxianxin
 * 针对表【pms_category(商品三级分类)】的数据库操作Service实现
 * @since 2021-12-02 18:42:19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

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
        // TODO 关联删除校验
        baseMapper.deleteBatchIds(Arrays.asList(ids));
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
}




