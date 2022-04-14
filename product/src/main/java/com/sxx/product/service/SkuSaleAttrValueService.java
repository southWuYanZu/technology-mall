package com.sxx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.PageUtils;
import com.sxx.product.entity.SkuSaleAttrValue;
import com.sxx.product.vo.SkuItemSaleAttrVo;

import java.util.List;
import java.util.Map;

/**
* @author shenxianxin
*  针对表【pms_sku_sale_attr_value(sku销售属性&值)】的数据库操作Service
* @since 2021-12-02 18:42:19
*/
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValue> {

    PageUtils queryPage(Map<String, Object> params);

    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}
