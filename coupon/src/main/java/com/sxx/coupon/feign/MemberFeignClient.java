package com.sxx.coupon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(value = "member")
public interface MemberFeignClient {

    @GetMapping("member/memberList")
    Map<String,Object> memberList();
}
