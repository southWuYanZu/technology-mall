package com.sxx.product.mapper;

import com.sxx.product.entity.SkuSaleAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxx.product.vo.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shenxianxin
*  针对表【pms_sku_sale_attr_value(sku销售属性&值)】的数据库操作Mapper
* @since 2021-12-02 18:42:19
* @Entity com.sxx.product.entity.SkuSaleAttrValue
*/
public interface SkuSaleAttrValueMapper extends BaseMapper<SkuSaleAttrValue> {

    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(@Param("spuId") Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(@Param("skuId") Long skuId);
}




