package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 秒杀活动场次
 * @TableName sms_seckill_session
 */
@TableName(value ="sms_seckill_session")
@Data
public class SeckillSession implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 场次名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 每日开始时间
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 每日结束时间
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 启用状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}