package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品满减信息
 *
 * @author shenxianxin
 * @TableName sms_sku_full_reduction
 */
@TableName(value = "sms_sku_full_reduction")
@Data
public class SkuFullReduction implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * spu_id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 满多少
     */
    @TableField(value = "full_price")
    private BigDecimal fullPrice;

    /**
     * 减多少
     */
    @TableField(value = "reduce_price")
    private BigDecimal reducePrice;

    /**
     * 是否参与其他优惠
     */
    private Integer addOther;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}