package com.sxx.product.feign;

import com.sxx.common.to.SkuReductionTo;
import com.sxx.common.to.SpuBoundTo;
import com.sxx.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 会员系统远程调用接口
 *
 * @author shenxianxin
 */
@FeignClient(value = "coupon")
public interface CouponFeignClient {

    /**
     * 发布商品保存该商品的积分信息
     *
     * @param spuBoundTo 商品优惠信息
     * @return 保存状态
     */
    @PostMapping("coupon/spuBounds/save")
    ResponseEntity saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    /**
     * (商品满减信息)新增
     *
     * @param skuReductionTo (商品满减信息)信息
     * @return 新增状态
     */
    @PostMapping("coupon/skuFullReduction/saveInfo")
    ResponseEntity saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
