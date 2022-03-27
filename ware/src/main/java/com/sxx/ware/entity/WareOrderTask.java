package com.sxx.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 库存工作单
 * @TableName wms_ware_order_task
 */
@TableName(value ="wms_ware_order_task")
@Data
public class WareOrderTask implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * order_id
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * order_sn
     */
    @TableField(value = "order_sn")
    private String orderSn;

    /**
     * 收货人
     */
    @TableField(value = "consignee")
    private String consignee;

    /**
     * 收货人电话
     */
    @TableField(value = "consignee_tel")
    private String consigneeTel;

    /**
     * 配送地址
     */
    @TableField(value = "delivery_address")
    private String deliveryAddress;

    /**
     * 订单备注
     */
    @TableField(value = "order_comment")
    private String orderComment;

    /**
     * 付款方式【 1:在线付款 2:货到付款】
     */
    @TableField(value = "payment_way")
    private Integer paymentWay;

    /**
     * 任务状态
     */
    @TableField(value = "task_status")
    private Integer taskStatus;

    /**
     * 订单描述
     */
    @TableField(value = "order_body")
    private String orderBody;

    /**
     * 物流单号
     */
    @TableField(value = "tracking_no")
    private String trackingNo;

    /**
     * create_time
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 仓库id
     */
    @TableField(value = "ware_id")
    private Long wareId;

    /**
     * 工作单备注
     */
    @TableField(value = "task_comment")
    private String taskComment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}