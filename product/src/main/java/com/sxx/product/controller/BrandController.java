package com.sxx.product.controller;

import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.common.validate.AddGroup;
import com.sxx.common.validate.Status;
import com.sxx.common.validate.UpdateGroup;
import com.sxx.product.entity.Brand;
import com.sxx.product.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 品牌
 *
 * @author Mr.shen
 * @since 2022/1/13
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("product/brand")
public class BrandController {

    private final BrandService brandService;

    /**
     * 获取品牌列表
     *
     * @param params 品牌过滤参数
     * @return 列表集合
     */
    @GetMapping("list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);
        return ResponseEntity.ok().put("page", page);
    }


    /**
     * 根据品牌id获取品牌详细信息
     *
     * @param brandId 品牌id
     * @return 品牌详情
     */
    @GetMapping("info/{brandId}")
    public ResponseEntity info(@PathVariable("brandId") Long brandId) {
        Brand brand = brandService.getById(brandId);

        return ResponseEntity.ok().put("brand", brand);
    }

    /**
     * 添加品牌
     *
     * @param brand 品牌信息
     * @return 添加状态
     */
    @PostMapping("/save")
    public ResponseEntity save(@Validated(AddGroup.class) @RequestBody Brand brand) {
        brandService.save(brand);
        return ResponseEntity.ok();
    }

    /**
     * 修改品牌
     *
     * @param brand 品牌信息
     * @return 修改状态
     */
    @PostMapping("update")
    public ResponseEntity update(@Validated(UpdateGroup.class) @RequestBody Brand brand) {
        brandService.updateDetail(brand);
        return ResponseEntity.ok();
    }

    /**
     * 修改品牌状态
     *
     * @param brand 品牌信息
     * @return 修改状态
     */
    @PostMapping("update/status")
    public ResponseEntity updateStatus(@Validated(Status.class) @RequestBody Brand brand) {
        brandService.updateById(brand);
        return ResponseEntity.ok();
    }

    /**
     * 批量删除品牌
     *
     * @param brandIds 品牌集合
     * @return 删除状态
     */
    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));
        return ResponseEntity.ok();
    }

}
