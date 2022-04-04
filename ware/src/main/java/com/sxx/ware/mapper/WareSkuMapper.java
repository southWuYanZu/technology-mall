package com.sxx.ware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxx.ware.entity.WareSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询商品在哪个仓库有库存
     *
     * @param skuId skuId
     * @return 库存信息
     */
    List<Long> listWareIdHasSkuStock(@Param("skuId") Long skuId);

    /**
     * 查询sku是否有库存
     *
     * @param skuId id
     * @return 拥有库存的sku集合
     */
    Long getSkuStock(Long skuId);

    /**
     * 锁定库存
     *
     * @param skuId  skuId
     * @param wareId wareId
     * @param num    锁定数量
     * @return 成功条数
     */
    Long lockSkuStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);

    /**
     * 解锁库存
     *
     * @param skuId  skuId
     * @param wareId wareId
     * @param num    解锁数量
     */
    void unLockStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);
}




