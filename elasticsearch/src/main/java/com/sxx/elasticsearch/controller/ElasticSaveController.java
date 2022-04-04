package com.sxx.elasticsearch.controller;

import com.sxx.common.es.SkuEsModel;
import com.sxx.common.exception.BizCodeEnum;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.elasticsearch.service.ProductSaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author shenxianxin
 * @since 2022/4/3 21:43:06
 */


@Slf4j
@RequestMapping(value = "/search/save")
@RestController
@RequiredArgsConstructor
public class ElasticSaveController {

    private final ProductSaveService productSaveService;


    /**
     * 上架商品
     *
     * @param skuEsModels
     * @return
     */
    @PostMapping(value = "/product")
    public ResponseEntity productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) {

        boolean status = false;
        try {
            status = productSaveService.productStatusUp(skuEsModels);
        } catch (IOException e) {
            return ResponseEntity.error(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMessage());
        }

        if (status) {
            return ResponseEntity.error(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMessage());
        } else {
            return ResponseEntity.ok();
        }

    }


}
