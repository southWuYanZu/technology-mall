package com.sxx.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product")
public interface ProductFeignClient {
    
}
