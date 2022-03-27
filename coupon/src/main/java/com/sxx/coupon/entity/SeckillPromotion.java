package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 秒杀活动
 * @TableName sms_seckill_promotion
 */
@TableName(value ="sms_seckill_promotion")
@Data
public class SeckillPromotion implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 活动标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 开始日期
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 结束日期
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 上下线状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(value = "user_id")
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}