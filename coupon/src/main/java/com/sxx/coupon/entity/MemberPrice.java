package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品会员价格
 * @TableName sms_member_price
 */
@TableName(value ="sms_member_price")
@Data
public class MemberPrice implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 会员等级id
     */
    @TableField(value = "member_level_id")
    private Long memberLevelId;

    /**
     * 会员等级名
     */
    @TableField(value = "member_level_name")
    private String memberLevelName;

    /**
     * 会员对应价格
     */
    @TableField(value = "member_price")
    private BigDecimal memberPrice;

    /**
     * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
     */
    @TableField(value = "add_other")
    private Integer addOther;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}