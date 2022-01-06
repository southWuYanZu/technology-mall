package com.sxx.product.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "coupon")
public interface CouponFeignClient {

}
