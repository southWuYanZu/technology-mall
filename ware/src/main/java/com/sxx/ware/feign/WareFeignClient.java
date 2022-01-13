package com.sxx.ware.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ware")
public interface WareFeignClient {

}
