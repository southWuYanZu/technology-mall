package com.sxx.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxx.product.entity.Attr;
import com.sxx.product.entity.AttrAttrgroupRelation;

import java.util.List;

/**
 * @author shenxianxin
 * 针对表【pms_attr_attrgroup_relation(属性&属性分组关联)】的数据库操作Mapper
 * @Entity com.sxx.product.entity.AttrAttrgroupRelation
 * @since 2021-12-02 18:42:19
 */
public interface AttrAttrgroupRelationMapper extends BaseMapper<AttrAttrgroupRelation> {

    /**
     * 根据商品属性id批量删除商品组关联信息
     *
     * @param attrs 属性ids
     * @return 删除是否成功
     */
    boolean deleteBatchByAttrIds(List<Attr> attrs);
}




