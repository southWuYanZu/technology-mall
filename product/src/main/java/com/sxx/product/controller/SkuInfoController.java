package com.sxx.product.controller;

import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.SkuInfo;
import com.sxx.product.service.SkuInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;


/**
 * sku信息
 *
 * @author Mr.shen
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("product/skuinfo")
public class SkuInfoController {

    private final SkuInfoService skuInfoService;

    /**
     * 根据skuId查询当前商品的价格
     *
     * @param skuId skuId
     * @return 价格详情
     */
    @GetMapping(value = "/{skuId}/price")
    public BigDecimal getPrice(@PathVariable("skuId") Long skuId) {

        //获取当前商品的信息
        SkuInfo skuInfo = skuInfoService.getById(skuId);

        //获取商品的价格
        return skuInfo.getPrice();


    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuInfoService.queryPage(params);

        return ResponseEntity.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    public ResponseEntity info(@PathVariable("skuId") Long skuId) {
        SkuInfo skuInfo = skuInfoService.getById(skuId);

        return ResponseEntity.ok().put("skuInfo", skuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody SkuInfo skuInfo) {
        skuInfoService.save(skuInfo);

        return ResponseEntity.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody SkuInfo skuInfo) {
        skuInfoService.updateById(skuInfo);

        return ResponseEntity.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] skuIds) {
        skuInfoService.removeByIds(Arrays.asList(skuIds));

        return ResponseEntity.ok();
    }
}
