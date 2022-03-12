package com.sxx.product.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.service.SpuInfoService;
import com.sxx.product.vo.SpuSaveVo;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * spu信息
 *
 * @author Mr.shen
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("product/spuinfo")
public class SpuInfoController {

    private final SpuInfoService spuInfoService;

    /**
     * 新增商品信息
     *
     * @param spuSaveVo 商品详情
     * @return 新增状态
     */
    @Transactional
    @PostMapping("save")
    @ApiOperation("新增商品")
    public ResponseEntity save(@RequestBody SpuSaveVo spuSaveVo) {
        return spuInfoService.saveSpuInfo(spuSaveVo);
    }
}
