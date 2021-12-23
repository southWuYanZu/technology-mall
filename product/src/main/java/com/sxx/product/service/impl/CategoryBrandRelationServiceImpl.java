package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.CategoryBrandRelation;
import com.sxx.product.service.CategoryBrandRelationService;
import com.sxx.product.mapper.CategoryBrandRelationMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【pms_category_brand_relation(品牌分类关联)】的数据库操作Service实现
* @since 2021-12-02 18:42:19
*/
@Service
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationMapper, CategoryBrandRelation>
    implements CategoryBrandRelationService{

}




