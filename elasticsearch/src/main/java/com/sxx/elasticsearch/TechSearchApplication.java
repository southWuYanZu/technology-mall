package com.sxx.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenxianxin
 */
@EnableDiscoveryClient
@EnableFeignClients()
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TechSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechSearchApplication.class, args);
    }

}

