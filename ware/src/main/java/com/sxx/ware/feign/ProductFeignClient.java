package com.sxx.ware.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product")
public interface ProductFeignClient {
    
}
