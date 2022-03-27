package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.CategoryBrandRelation;
import com.sxx.product.enums.ProConsEnums;
import com.sxx.product.mapper.BrandMapper;
import com.sxx.product.mapper.CategoryBrandRelationMapper;
import com.sxx.product.mapper.CategoryMapper;
import com.sxx.product.service.CategoryBrandRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shenxianxin
 * 针对表【pms_category_brand_relation(品牌分类关联)】的数据库操作Service实现
 * @since 2021-12-02 18:42:19
 */
@Service
@RequiredArgsConstructor
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationMapper, CategoryBrandRelation>
        implements CategoryBrandRelationService {

    private final BrandMapper brandMapper;

    private final CategoryMapper categoryMapper;

    /**
     * 保存关联关系
     *
     * @param relation 新增关联实体
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveDetail(CategoryBrandRelation relation) {
        Long brandId = relation.getBrandId();
        //获取品牌名称
        String brandName = brandMapper.selectById(brandId).getName();
        Long catelogId = relation.getCatelogId();
        //获取分组名称
        String categoryName = categoryMapper.selectById(catelogId).getName();
        relation.setBrandName(brandName);
        relation.setCatelogName(categoryName);
        return this.save(relation);
    }

    /**
     * 更改关联表品牌名称
     *
     * @param brandId   品牌ID
     * @param brandName 品牌名称
     */
    @Override
    public void updateBrandName(Long brandId, String brandName) {
        CategoryBrandRelation relation = new CategoryBrandRelation();
        relation.setBrandId(brandId);
        relation.setBrandName(brandName);
        this.update(relation, new QueryWrapper<CategoryBrandRelation>().eq(ProConsEnums.COLUMN_BRAND_ID, brandId));
    }

    @Override
    public ResponseEntity getBrandByCategory(Long catId) {
        List<CategoryBrandRelation> brands = this.list(new QueryWrapper<CategoryBrandRelation>().eq(ProConsEnums.COLUMN_CATELOG_ID, catId));
        return ResponseEntity.ok("data", brands);
    }
}




