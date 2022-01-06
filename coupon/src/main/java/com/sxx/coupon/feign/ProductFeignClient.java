package com.sxx.coupon.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product")
public interface ProductFeignClient {
    
}
