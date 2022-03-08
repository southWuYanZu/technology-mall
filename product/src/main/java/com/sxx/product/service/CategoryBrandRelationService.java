package com.sxx.product.service;

import com.sxx.product.entity.CategoryBrandRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author shenxianxin
 * 针对表【pms_category_brand_relation(品牌分类关联)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelation> {

    /**
     * 保存关联关系
     *
     * @param relation 新增关联实体
     * @return 是否成功
     */
    boolean saveDetail(CategoryBrandRelation relation);

    /**
     * 更改关联表品牌名称
     *
     * @param brandId   品牌ID
     * @param brandName 品牌名称
     */
    void updateBrandName(Long brandId, String brandName);
}
