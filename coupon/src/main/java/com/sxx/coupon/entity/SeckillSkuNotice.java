package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 秒杀商品通知订阅
 * @TableName sms_seckill_sku_notice
 */
@TableName(value ="sms_seckill_sku_notice")
@Data
public class SeckillSkuNotice implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * member_id
     */
    @TableField(value = "member_id")
    private Long memberId;

    /**
     * sku_id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 活动场次id
     */
    @TableField(value = "session_id")
    private Long sessionId;

    /**
     * 订阅时间
     */
    @TableField(value = "subcribe_time")
    private Date subcribeTime;

    /**
     * 发送时间
     */
    @TableField(value = "send_time")
    private Date sendTime;

    /**
     * 通知方式[0-短信，1-邮件]
     */
    @TableField(value = "notice_type")
    private Integer noticeType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}