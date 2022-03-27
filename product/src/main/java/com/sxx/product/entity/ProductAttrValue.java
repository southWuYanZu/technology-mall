package com.sxx.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * spu属性值
 *
 * @author shenxianxin
 * @TableName pms_product_attr_value
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "pms_product_attr_value")
public class ProductAttrValue implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    @TableField(value = "spu_id")
    private Long spuId;

    /**
     * 属性id
     */
    @TableField(value = "attr_id")
    private Long attrId;

    /**
     * 属性名
     */
    @TableField(value = "attr_name")
    private String attrName;

    /**
     * 属性值
     */
    @TableField(value = "attr_value")
    private String attrValue;

    /**
     * 顺序
     */
    @TableField(value = "attr_sort")
    private Integer attrSort;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @TableField(value = "quick_show")
    private int quickShow;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}