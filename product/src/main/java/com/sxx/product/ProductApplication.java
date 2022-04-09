package com.sxx.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenxianxin
 * @since 2021/12/2
 */

@EnableCaching
@EnableDiscoveryClient
@MapperScan(basePackages = "com.sxx.product.mapper")
@EnableFeignClients(basePackages = "com.sxx.product.feign")
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
