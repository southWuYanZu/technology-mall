package com.sxx.product.feign;

import com.sxx.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shenxianxin
 **/

@FeignClient(value = "gulimall-seckill")
public interface SeckillFeignService {

    /**
     * 根据skuId查询商品是否参加秒杀活动
     * @param skuId
     * @return
     */
    @GetMapping(value = "/sku/seckill/{skuId}")
    ResponseEntity getSkuSeckilInfo(@PathVariable("skuId") Long skuId);

}
