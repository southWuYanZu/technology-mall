package com.sxx.ware.feign;

import com.sxx.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shenxianxin
 * @since 2022/3/28
 */
@FeignClient(value = "product")
public interface ProductFeignClient {

    /**
     * 根据skuId 获取sku详情
     *
     * @param skuId skuId
     * @return skuInfo
     */
    @RequestMapping("api/product/skuinfo/info/{skuId}")
    public ResponseEntity info(@PathVariable("skuId") Long skuId);

}
