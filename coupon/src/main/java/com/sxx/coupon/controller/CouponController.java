package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.feign.MemberFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("coupon")
public class CouponController {

    private final MemberFeignClient feignClient;

    @GetMapping("getMember")
    public ResponseEntity getMember() {
        Map<String, Object> map = feignClient.memberList();
        return ResponseEntity.ok().put("res",map);
    }
}
