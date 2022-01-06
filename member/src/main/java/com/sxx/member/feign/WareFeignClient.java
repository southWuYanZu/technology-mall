package com.sxx.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ware")
public interface WareFeignClient {
    
}
