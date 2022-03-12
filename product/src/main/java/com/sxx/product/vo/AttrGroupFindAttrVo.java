package com.sxx.product.vo;

import com.sxx.product.entity.Attr;
import com.sxx.product.entity.AttrGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.shen
 * @since 2022/03/12 上午 11:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AttrGroupFindAttrVo extends AttrGroup implements Serializable {

    /**
     * 商品属性分组信息
     */
    private List<Attr> attrList;
}
