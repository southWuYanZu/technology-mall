package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券信息
 * @author shenxianxin
 * @TableName sms_coupon
 */
@TableName(value ="sms_coupon")
@Data
public class Coupon implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]
     */
    @TableField(value = "coupon_type")
    private Integer couponType;

    /**
     * 优惠券图片
     */
    @TableField(value = "coupon_img")
    private String couponImg;

    /**
     * 优惠卷名字
     */
    @TableField(value = "coupon_name")
    private String couponName;

    /**
     * 数量
     */
    @TableField(value = "num")
    private Integer num;

    /**
     * 金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 每人限领张数
     */
    @TableField(value = "per_limit")
    private Integer perLimit;

    /**
     * 使用门槛
     */
    @TableField(value = "min_point")
    private BigDecimal minPoint;

    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 使用类型[0->全场通用；1->指定分类；2->指定商品]
     */
    @TableField(value = "use_type")
    private Integer useType;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    /**
     * 发行数量
     */
    @TableField(value = "publish_count")
    private Integer publishCount;

    /**
     * 已使用数量
     */
    @TableField(value = "use_count")
    private Integer useCount;

    /**
     * 领取数量
     */
    @TableField(value = "receive_count")
    private Integer receiveCount;

    /**
     * 可以领取的开始日期
     */
    @TableField(value = "enable_start_time")
    private Date enableStartTime;

    /**
     * 可以领取的结束日期
     */
    @TableField(value = "enable_end_time")
    private Date enableEndTime;

    /**
     * 优惠码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 可以领取的会员等级[0->不限等级，其他-对应等级]
     */
    @TableField(value = "member_level")
    private Integer memberLevel;

    /**
     * 发布状态[0-未发布，1-已发布]
     */
    @TableField(value = "publish")
    private Integer publish;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}