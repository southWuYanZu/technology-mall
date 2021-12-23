package com.sxx.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shenxianxin
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.sxx.ware.mapper")
public class WareApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class, args);
    }
}
