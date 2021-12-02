package com.sxx.coupon;

import com.sxx.coupon.entity.Coupon;
import com.sxx.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class CouponApplicationTests {
    @Autowired
    private CouponService couponService;
    @Test
    void contextLoads() {
        Coupon coupon = new Coupon();
        coupon.setCouponName("hello coupon");
        couponService.save(coupon);
    }

}
