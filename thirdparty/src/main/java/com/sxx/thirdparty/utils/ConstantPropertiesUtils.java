package com.sxx.thirdparty.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Mr.shen
 * @since 2021/6/21
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;

    @Value("${spring.cloud.alicloud.access-key}")
    private String keyId;

    @Value("${spring.cloud.alicloud.secret-key}")
    private String keySecret;

    @Value("${bucketname}")
    private String bucketName;

    public static String END_POINT;
    public static String KEY_ID ;
    public static String KEY_SECRET;
    public static String BUCKET_NAME ;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        KEY_ID = keyId;
        KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
