package com.sxx.product.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.service.AttrGroupService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity attrList(@RequestParam Map<String, Object> params, @PathVariable Long catId) {
        return attrGroupService.queryPage(params, catId);
    }

}