package com.sxx.coupon.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "order")
public interface OrderFeignClient {
    
}
