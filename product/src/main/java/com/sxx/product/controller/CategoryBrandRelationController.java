package com.sxx.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.CategoryBrandRelation;
import com.sxx.product.service.CategoryBrandRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 品牌分类关联
 *
 * @author Mr.shen
 * @since 2022-3-8
 */
@RestController
@Api("品牌分类关联")
@RequiredArgsConstructor
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    private final CategoryBrandRelationService relationService;

    /**
     * 根据品牌ID获取品牌分类列表
     *
     * @param brandId 品牌ID
     * @return list
     */
    @GetMapping("catelog/list")
    @ApiOperation("品牌分类列表")
    public ResponseEntity categoryList(@RequestParam Long brandId) {
        List<CategoryBrandRelation> relations = relationService.list(new QueryWrapper<CategoryBrandRelation>()
                .eq("brand_id", brandId));
        return ResponseEntity.ok("data", relations);
    }

    /**
     * 根据品类获取旗下品牌
     *
     * @param catId 品类id
     * @return 品牌结果集
     */
    @GetMapping("brands/list")
    @ApiOperation("根据品类获取旗下品牌")
    public ResponseEntity getBrandByCategory(@RequestParam Long catId) {
        return relationService.getBrandByCategory(catId);
    }

    /**
     * 保存关联关系
     *
     * @param relation 新增关联实体
     * @return 是否成功
     */
    @PostMapping("save")
    @ApiOperation("分类关联保存")
    public ResponseEntity save(@RequestBody CategoryBrandRelation relation) {
        boolean flag = relationService.saveDetail(relation);
        return flag ? ResponseEntity.ok("保存成功") : ResponseEntity.error("保存失败");
    }

    /**
     * 移除品牌关联关系
     *
     * @param brandIds 品牌ID
     * @return 是否成功
     */
    @PostMapping("delete")
    @ApiOperation("删除品牌关联关系")
    public ResponseEntity delete(@RequestBody Long[] brandIds) {
        boolean flag = relationService.removeByIds(Arrays.asList(brandIds));
        return flag ? ResponseEntity.ok("移除成功") : ResponseEntity.error("移除失败");
    }


}