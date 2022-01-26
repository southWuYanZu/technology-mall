package com.sxx.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenxianxin
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ThirdpartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdpartyApplication.class, args);
    }
}
