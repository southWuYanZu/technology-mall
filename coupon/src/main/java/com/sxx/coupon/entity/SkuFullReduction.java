package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品满减信息
 * @TableName sms_sku_full_reduction
 */
@TableName(value ="sms_sku_full_reduction")
@Data
public class SkuFullReduction implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    @TableField(value = "add_other")
    private Integer addOther;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}