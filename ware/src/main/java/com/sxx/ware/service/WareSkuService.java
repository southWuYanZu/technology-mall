package com.sxx.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareSku;
import com.sxx.ware.vo.SkuHasStockVo;

import java.util.List;
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


    /**
     * 查询sku是否有库存
     *
     * @param skuIds skuIds
     * @return 拥有库存的sku集合
     */
    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

}
