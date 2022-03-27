package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 秒杀活动商品关联
 * @TableName sms_seckill_sku_relation
 */
@TableName(value ="sms_seckill_sku_relation")
@Data
public class SeckillSkuRelation implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 活动id
     */
    @TableField(value = "promotion_id")
    private Long promotionId;

    /**
     * 活动场次id
     */
    @TableField(value = "promotion_session_id")
    private Long promotionSessionId;

    /**
     * 商品id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 秒杀价格
     */
    @TableField(value = "seckill_price")
    private Integer seckillPrice;

    /**
     * 秒杀总量
     */
    @TableField(value = "seckill_count")
    private Integer seckillCount;

    /**
     * 每人限购数量
     */
    @TableField(value = "seckill_limit")
    private Integer seckillLimit;

    /**
     * 排序
     */
    @TableField(value = "seckill_sort")
    private Integer seckillSort;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}