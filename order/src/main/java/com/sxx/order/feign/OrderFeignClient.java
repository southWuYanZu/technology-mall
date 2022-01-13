package com.sxx.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "order")
public interface OrderFeignClient {

}
