package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * @TableName sms_home_subject
 */
@TableName(value ="sms_home_subject")
@Data
public class HomeSubject implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 专题名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 专题标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 专题副标题
     */
    @TableField(value = "sub_title")
    private String subTitle;

    /**
     * 显示状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 详情连接
     */
    @TableField(value = "url")
    private String url;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 专题图片地址
     */
    @TableField(value = "img")
    private String img;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}