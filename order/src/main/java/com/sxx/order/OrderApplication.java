package com.sxx.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenxianxin
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.sxx.order.mapper")
@EnableFeignClients(basePackages = "com.sxx.order.feign")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
