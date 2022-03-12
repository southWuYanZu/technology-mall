package com.sxx.product.vo;

import com.sxx.product.entity.SkuImages;
import com.sxx.product.entity.SkuInfo;
import com.sxx.product.entity.SpuInfoDesc;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Mr.shen
 * @since 2022/03/12 上午 11:23
 */


@ToString
@Data
public class SkuItemVo {

    /**
     * 1、sku基本信息的获取  pms_sku_info
     */
    private SkuInfo info;

    private boolean hasStock = true;

    /**
     * sku的图片信息    pms_sku_images
     */
    private List<SkuImages> images;

    /**
     * 获取spu的销售属性组合
     */
    private List<SkuItemSaleAttrVo> saleAttr;

    /**
     * 获取spu的介绍
     */
    private SpuInfoDesc desc;

    /**
     * 获取spu的规格参数信息
     */
    private List<SpuItemAttrGroupVo> groupAttrs;

    /**
     * 秒杀商品的优惠信息
     */
    private SeckillSkuVo seckillSkuVo;

}
