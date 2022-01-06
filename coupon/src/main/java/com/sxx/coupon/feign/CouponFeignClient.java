package com.sxx.coupon.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "coupon")
public interface CouponFeignClient {

}
