package com.sxx.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "member")
public interface MemberFeignClient {

}
