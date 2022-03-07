package com.sxx.product.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.service.AttrGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
     * @param id 属性ID
     * @return 是否被删除
     */
    @PostMapping("delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(Double id) {
        boolean flag = attrGroupService.removeById(id);
        return flag ? ResponseEntity.ok("分组删除成功") : ResponseEntity.error("分组删除失败");
    }
}
