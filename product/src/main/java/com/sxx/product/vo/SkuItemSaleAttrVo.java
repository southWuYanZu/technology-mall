package com.sxx.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Mr.shen
 * @since 2022/03/12 上午 11:23
 */

@Data
@ToString
public class SkuItemSaleAttrVo {

    private Long attrId;

    private String attrName;

    private List<AttrValueWithSkuIdVo> attrValues;

}
