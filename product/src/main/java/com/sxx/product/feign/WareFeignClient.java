package com.sxx.product.feign;

import com.sxx.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author shenxianxin
 */
@FeignClient(value = "ware")
public interface WareFeignClient {

    /**
     * 查询当前sku 是否拥有库存
     *
     * @param skuIdList skus
     * @return 拥有库存的sku
     */
    @PostMapping(value = "/ware/waresku/hasStock")
    ResponseEntity getSkuHasStock(List<Long> skuIdList);

}
