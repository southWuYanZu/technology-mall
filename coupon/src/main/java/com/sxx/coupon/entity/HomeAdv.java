package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 首页轮播广告
 * @TableName sms_home_adv
 */
@TableName(value ="sms_home_adv")
@Data
public class HomeAdv implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 图片地址
     */
    @TableField(value = "pic")
    private String pic;

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
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 点击数
     */
    @TableField(value = "click_count")
    private Integer clickCount;

    /**
     * 广告详情连接地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 发布者
     */
    @TableField(value = "publisher_id")
    private Long publisherId;

    /**
     * 审核者
     */
    @TableField(value = "auth_id")
    private Long authId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}