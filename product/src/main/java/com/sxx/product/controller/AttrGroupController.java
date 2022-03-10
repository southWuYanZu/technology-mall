package com.sxx.product.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.AttrAttrgroupRelation;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.service.AttrAttrGroupRelationService;
import com.sxx.product.service.AttrGroupService;
import com.sxx.product.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 属性分组
 *
 * @author Mr.shen
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("product/attrgroup")
public class AttrGroupController {

    private final AttrAttrGroupRelationService relationService;

    private final AttrGroupService attrGroupService;

    private final CategoryService categoryService;

    /**
     * 获取属性分组列表
     *
     * @param params 属性分组参数 包含当前页,分页条数...
     * @param catId  三级分类ID 区别查询列表全部还是 ID 信息
     * @return 数据集
     */
    @ApiOperation("属性分组列表")
    @GetMapping("list/{catId}")
    public ResponseEntity attrList(@RequestParam Map<String, Object> params,
                                   @PathVariable Long catId) {
        return attrGroupService.queryPage(params, catId);
    }

    /**
     * 根据分组id 查询当前分组下所有商品属性
     *
     * @param attrgroupId 分组id
     * @return 商品属性列表
     */
    @ApiOperation("当前分组商品信息列表")
    @GetMapping("{attrgroupId}/attr/relation")
    public ResponseEntity attrRelation(@PathVariable Long attrgroupId) {
        return attrGroupService.attrRelationShip(attrgroupId);
    }

    /**
     * 查询没有在当前分组下的所有商品属性
     *
     * @param attrGroupId 当前分组id
     * @param params      分页条件
     * @return 其他商品属性集
     */
    @ApiOperation("属性分组没有的商品属性列表")
    @GetMapping("{attrGroupId}/noAttr/relation")
    public ResponseEntity getNotInAttrGroupList(@PathVariable Long attrGroupId,
                                                @RequestParam Map<String, Object> params) {
        return attrGroupService.getNotInAttrGroupList(attrGroupId, params);
    }

    /**
     * 根据categoryID查询详细信息进行回写
     *
     * @param categoryId ID
     * @return 回写分组详细信息
     */
    @ApiOperation("分组详情")
    @GetMapping("info/{categoryId}")
    public ResponseEntity info(@PathVariable Long categoryId) {
        AttrGroup group = attrGroupService.getById(categoryId);
        Long[] categoryPath = categoryService.findCategoryPathById(group.getCatelogId());
        group.setCatelogPath(categoryPath);
        return ResponseEntity.ok("attrGroup", group);
    }

    /**
     * 新增属性分组
     *
     * @param attrGroup 分组信息
     * @return 是否成功
     */
    @PostMapping("save")
    @ApiOperation("属性新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody AttrGroup attrGroup) {
        boolean flag = attrGroupService.save(attrGroup);
        return flag ? ResponseEntity.ok("分组新增成功") : ResponseEntity.error("分组新增失败");
    }

    /**
     * 修改属性分组
     *
     * @param attrGroup 分组信息
     * @return 修改是否成功
     */
    @PostMapping("update")
    @ApiOperation("属性分组修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody AttrGroup attrGroup) {
        boolean flag = attrGroupService.updateById(attrGroup);
        return flag ? ResponseEntity.ok("分组修改成功") : ResponseEntity.error("分组修改失败");
    }

    /**
     * 根据分组ID删除对应属性
     *
     * @param ids 属性ID
     * @return 是否被删除
     */
    @PostMapping("delete")
    @ApiOperation("属性删除ById")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody Long[] ids) {
        boolean flag = attrGroupService.removeByIds(Arrays.asList(ids));
        return flag ? ResponseEntity.ok("分组删除成功") : ResponseEntity.error("分组删除失败");
    }


    /**
     * 删除指定分组下指定商品属性
     *
     * @param relation 关联信息
     * @return 删除是否成功
     */
    @ApiOperation("分组属性删除")
    @PostMapping("attr/relation/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity relationDelete(@RequestBody List<AttrAttrgroupRelation> relation) {
        boolean flag = relationService.relationDelete(relation);
        return flag ? ResponseEntity.ok("分组属性删除成功") : ResponseEntity.error("分组属性删除失败");
    }
}
