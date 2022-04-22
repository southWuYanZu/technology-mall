package com.sxx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.AttrAttrgroupRelation;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.vo.AttrGroupWithAttrsVo;
import com.sxx.product.vo.SpuItemAttrGroupVo;

import java.util.List;
import java.util.Map;

/**
 * 针对表【pms_attr_group(属性分组)】的数据库操作Service
 *
 * @author shenxianxin
 * @since 2021-12-02 18:42:19
 */
public interface AttrGroupService extends IService<AttrGroup> {

    /**
     * 获取属性分组列表
     *
     * @param params 属性分组参数 包含当前页,分页条数...
     * @param catId  三级分类ID 区别查询列表全部还是 ID 信息
     * @return 数据集
     */
    ResponseEntity queryPage(Map<String, Object> params, Long catId);

    /**
     * 根据分组id 查询当前分组下所有商品属性
     *
     * @param attrgroupId 分组id
     * @return 商品属性列表
     */
    ResponseEntity attrRelationShip(Long attrgroupId);

    /**
     * 查询没有在当前分组下的所有商品属性
     *
     * @param attrGroupId 当前分组id
     * @param params      分页条件
     * @return 其他商品属性集
     */
    ResponseEntity getNotInAttrGroupList(Long attrGroupId, Map<String, Object> params);

    /**
     * 指定分组下新增指定属性
     *
     * @param relations 分组和属性关联关系
     * @return 新增状态
     */
    boolean saveAttrRelationship(List<AttrAttrgroupRelation> relations);

    /**
     * 根据分类ID获取指定分组下的所以属性
     *
     * @param catelogId 分类ID
     * @return 商品属性结果集
     */
    ResponseEntity getAttrByCatelogId(long catelogId);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}
