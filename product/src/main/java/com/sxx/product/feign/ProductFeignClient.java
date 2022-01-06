package com.sxx.product.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product")
public interface ProductFeignClient {
    
}
