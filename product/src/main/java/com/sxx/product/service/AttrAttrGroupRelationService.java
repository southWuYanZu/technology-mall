package com.sxx.product.service;

import com.sxx.product.entity.AttrAttrgroupRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author shenxianxin
 * 针对表【pms_attr_attrgroup_relation(属性&属性分组关联)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface AttrAttrGroupRelationService extends IService<AttrAttrgroupRelation> {

    /**
     * 删除指定分组下指定商品属性
     *
     * @param relation 关联信息
     * @return 删除是否成功
     */
    boolean relationDelete(List<AttrAttrgroupRelation> relation);
}
