package com.sxx.product.feign;

import com.sxx.common.es.SkuEsModel;
import com.sxx.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Es系统远程调用接口
 *
 * @author shenxianxin
 */
@FeignClient(value = "search")
public interface SearchFeignClient {


    /**
     * 将sku信息发送给Es进行保存
     *
     * @param collect 检索信息
     * @return 响应
     */
    @PostMapping(value = "/search/save/product")
    ResponseEntity productStatusUp(List<SkuEsModel> collect);
}
