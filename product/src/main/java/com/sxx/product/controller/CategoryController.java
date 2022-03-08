package com.sxx.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.util.StringUtils;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.Category;
import com.sxx.product.entity.CategoryBrandRelation;
import com.sxx.product.service.CategoryBrandRelationService;
import com.sxx.product.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.shen
 * @since 2021/12/12
 */
@RestController
@Api(value = "商品品类")
@RequiredArgsConstructor
@RequestMapping("product/category")
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryBrandRelationService relationService;

    /**
     * 查询商品品类
     *
     * @return 品类结果集并按三级列表返回
     */
    @GetMapping("list/tree")
    @ApiOperation(value = "品类列表")
    public ResponseEntity listWithTree() {
        List<Category> categoryList = categoryService.listWithTree();
        return ResponseEntity.ok("tree", categoryList);
    }

    /**
     * 根据id集合删除商品品类
     *
     * @param ids 商品id集合
     */
    @PostMapping("delete")
    @ApiOperation(value = "批量删除品类")
    public ResponseEntity deleteMenuByIds(@RequestBody Long[] ids) {
        categoryService.deleteMenusByIds(ids);
        return ResponseEntity.ok();
    }

    /**
     * 新增品类
     *
     * @param category 品类信息
     * @return 成功状态码
     */
    @PostMapping("addCategory")
    @ApiOperation(value = "新增品类")
    public ResponseEntity addCategory(@RequestBody Category category) {
        if (StringUtils.isNullOrEmpty(category.getName()) && !"".equals(category.getName())) {
            categoryService.save(category);
            return ResponseEntity.ok();
        }
        return ResponseEntity.error();
    }

    /**
     * 修改品类
     *
     * @param category 当前品类信息
     * @return 成功状态码
     */
    @ApiOperation("修改品类")
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Category category) {
        categoryService.updateById(category);
        if (!StringUtils.isNullOrEmpty(category.getName())) {
            CategoryBrandRelation relation = new CategoryBrandRelation();
            relation.setCatelogName(category.getName());
            relationService.update(relation, new QueryWrapper<CategoryBrandRelation>()
                    .eq("catelog_id", category.getCatId()));
        }
        return ResponseEntity.ok();
    }
    /**
     * 批量修改品类
     *
     * @param category 当前品类信息集合
     * @return 成功状态码
     */
    @ApiOperation("批量修改品类")
    @PostMapping("/updateBatchById")
    public ResponseEntity update(@RequestBody List<Category> category) {
        categoryService.updateBatchById(category);
        return ResponseEntity.ok();
    }

    /**
     * 查询详情
     *
     * @param id 品类id
     * @return 品类信息
     */
    @ApiOperation("查询详情")
    @GetMapping("info/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        Category category = categoryService.getById(id);
        return ResponseEntity.ok("data", category);
    }
}
