package com.sxx.elasticsearch.feign;

import com.sxx.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author shenxianxin
 */
@FeignClient(value = "product")
public interface ProductFeignClient {

    @GetMapping("/product/attr/info/{attrId}")
    public ResponseEntity attrInfo(@PathVariable("attrId") Long attrId);

}
