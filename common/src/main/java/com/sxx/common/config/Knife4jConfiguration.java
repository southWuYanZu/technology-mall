package com.sxx.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Mr.shen
 * @since 2021/7/21
 */
@EnableKnife4j
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

    @Bean(value = "defaultApi3")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("# swagger-bootstrap-ui-demo RESTFUL APIs")
                        .termsOfServiceUrl("https://www.South_WoYanZu.com/")
                        .version("1.0")
                        .license("Mr.shen")
                        .build())
                //分组名称
                .groupName("3.0.0版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sxx.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}