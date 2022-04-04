package com.sxx.ware.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shenxianxin
 */
@FeignClient(value = "coupon")
public interface CouponFeignClient {

}
