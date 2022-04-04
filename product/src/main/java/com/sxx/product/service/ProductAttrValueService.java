package com.sxx.product.service;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.ProductAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author shenxianxin
 * 针对表【pms_product_attr_value(spu属性值)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface ProductAttrValueService extends IService<ProductAttrValue> {

    /**
     * 根据spuId 获取规格参数
     *
     * @param spuId spuId
     * @return 当前spu的规格参数
     */
    ResponseEntity baseAttrListForSpu(String spuId);

    /**
     * 根据spuId更新规格参数信息
     *
     * @param spuId    spuId
     * @param entities 更新集合
     * @return 更新状态
     */
    ResponseEntity updateSpuAttr(Long spuId, List<ProductAttrValue> entities);

    /**
     * 根据spuId查询attr信息
     * @param spuId spuId
     * @return attr
     */
    List<ProductAttrValue> baseAttrListForSpu(Long spuId);
}
