package com.sxx.ware.mapper;

import org.apache.ibatis.annotations.Param;

import com.sxx.ware.entity.WareSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 针对表【wms_ware_sku(商品库存)】的数据库操作Mapper
 *
 * @author Mr.shen
 * @Entity com.sxx.ware.entity.WareSku
 * @since 2022-03-27 16:45:54
 */
public interface WareSkuMapper extends BaseMapper<WareSku> {

    /**
     * 根据skuId和wareId 更新wareSku 库存信息
     *
     * @param stock  入库量
     * @param skuId  wareId
     * @param wareId wareId
     * @return 更新条数
     */
    int updateStockBySkuIdAndWareId(@Param("stock") Integer stock, @Param("skuId") Long skuId, @Param("wareId") Long wareId);
}




