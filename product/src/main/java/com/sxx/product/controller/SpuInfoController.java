package com.sxx.product.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.service.SpuInfoService;
import com.sxx.product.vo.SpuSaveVo;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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
     * 查询(spu信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(spu信息)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return spuInfoService.queryPage(params);
    }

    /**
     * 新增商品信息
     *
     * @param spuSaveVo 商品详情
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("新增商品")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SpuSaveVo spuSaveVo) {
        return spuInfoService.saveSpuInfo(spuSaveVo);
    }

    /**
     * 商品上架功能
     *
     * @param spuId spuId
     * @return 上架状态
     */
    @PostMapping("{spuId}/up")
    public ResponseEntity spuUp(@PathVariable("spuId") Long spuId) {
        spuInfoService.up(spuId);
        return ResponseEntity.ok();
    }
}
