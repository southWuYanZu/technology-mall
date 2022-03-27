package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 优惠券与产品关联
 * @TableName sms_coupon_spu_relation
 */
@TableName(value ="sms_coupon_spu_relation")
@Data
public class CouponSpuRelation implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券id
     */
    @TableField(value = "coupon_id")
    private Long couponId;

    /**
     * spu_id
     */
    @TableField(value = "spu_id")
    private Long spuId;

    /**
     * spu_name
     */
    @TableField(value = "spu_name")
    private String spuName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}