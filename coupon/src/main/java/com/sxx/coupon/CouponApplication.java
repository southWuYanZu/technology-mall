package com.sxx.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author shenxianxin
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.sxx.coupon.mapper")
@EnableFeignClients(basePackages = "com.sxx.coupon.feign")
public class CouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }

}
