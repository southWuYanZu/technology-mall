package com.sxx.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ware")
public interface WareFeignClient {

}
