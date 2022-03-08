package com.sxx.product.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.service.AttrGroupService;
import com.sxx.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    private final AttrGroupService attrGroupService;

    private final CategoryService categoryService;

    /**
     * 获取属性分组列表
     *
     * @param params 属性分组参数 包含当前页,分页条数...
     * @param catId  三级分类ID 区别查询列表全部还是 ID 信息
     * @return 数据集
     */
    @GetMapping("list/{catId}")
    public ResponseEntity attrList(@RequestParam Map<String, Object> params,
                                   @PathVariable Long catId) {
        return attrGroupService.queryPage(params, catId);
    }

    /**
     * 新增属性分组
     *
     * @param attrGroup 分组信息
     * @return 是否成功
     */
    @PostMapping("save")
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
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody Long[] ids) {
        boolean flag = attrGroupService.removeByIds(Arrays.asList(ids));
        return flag ? ResponseEntity.ok("分组删除成功") : ResponseEntity.error("分组删除失败");
    }

    /**
     * 根据categoryID查询详细信息进行回写
     *
     * @param categoryId ID
     * @return 回写分组详细信息
     */
    @GetMapping("info/{categoryId}")
    public ResponseEntity info(@PathVariable Long categoryId) {
        AttrGroup group = attrGroupService.getById(categoryId);
        Long[] categoryPath = categoryService.findCategoryPathById(group.getCatelogId());
        group.setCatelogPath(categoryPath);
        return ResponseEntity.ok("attrGroup", group);
    }

}
