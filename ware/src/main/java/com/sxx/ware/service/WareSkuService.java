package com.sxx.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareSku;

import java.util.Map;

/**
 * 针对表【wms_ware_sku(商品库存)】的数据库操作Service
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
public interface WareSkuService extends IService<WareSku> {

    /**
     * 查询(商品库存)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);

    /**
     * 添加库存
     *
     * @param skuId  skuId
     * @param wareId wareId
     * @param skuNum skuNum
     */
    void addStock(Long skuId, Long wareId, Integer skuNum);

/*    *//**
     * 判断是否有库存
     *
     * @param skuIds skuIds
     * @return 判断是否有库存
     *//*
    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

    *//**
     * 锁定库存
     *
     * @param vo WareSkuLockVo
     * @return 锁定库存
     *//*
    boolean orderLockStock(WareSkuLockVo vo);*/

}
