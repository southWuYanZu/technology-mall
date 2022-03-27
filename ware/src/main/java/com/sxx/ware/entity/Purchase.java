package com.sxx.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 采购信息
 * @TableName wms_purchase
 */
@TableName(value ="wms_purchase")
@Data
public class Purchase implements Serializable {
    /**
     * 采购单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购人id
     */
    @TableField(value = "assignee_id")
    private Long assigneeId;

    /**
     * 采购人名
     */
    @TableField(value = "assignee_name")
    private String assigneeName;

    /**
     * 联系方式
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 优先级
     */
    @TableField(value = "priority")
    private Integer priority;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 仓库id
     */
    @TableField(value = "ware_id")
    private Long wareId;

    /**
     * 总金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 创建日期
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新日期
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}