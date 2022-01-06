package com.sxx.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product")
public interface ProductFeignClient {
    
}
