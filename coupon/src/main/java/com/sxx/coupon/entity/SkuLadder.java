package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品阶梯价格
 * @TableName sms_sku_ladder
 */
@TableName(value ="sms_sku_ladder")
@Data
public class SkuLadder implements Serializable {
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
     * 满几件
     */
    @TableField(value = "full_count")
    private Integer fullCount;

    /**
     * 打几折
     */
    @TableField(value = "discount")
    private BigDecimal discount;

    /**
     * 折后价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 是否叠加其他优惠[0-不可叠加，1-可叠加]
     */
    @TableField(value = "add_other")
    private Integer addOther;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}