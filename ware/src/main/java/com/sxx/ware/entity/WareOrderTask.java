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
    private Boolean paymentWay;

    /**
     * 任务状态
     */
    @TableField(value = "task_status")
    private Byte taskStatus;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WareOrderTask other = (WareOrderTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getConsigneeTel() == null ? other.getConsigneeTel() == null : this.getConsigneeTel().equals(other.getConsigneeTel()))
            && (this.getDeliveryAddress() == null ? other.getDeliveryAddress() == null : this.getDeliveryAddress().equals(other.getDeliveryAddress()))
            && (this.getOrderComment() == null ? other.getOrderComment() == null : this.getOrderComment().equals(other.getOrderComment()))
            && (this.getPaymentWay() == null ? other.getPaymentWay() == null : this.getPaymentWay().equals(other.getPaymentWay()))
            && (this.getTaskStatus() == null ? other.getTaskStatus() == null : this.getTaskStatus().equals(other.getTaskStatus()))
            && (this.getOrderBody() == null ? other.getOrderBody() == null : this.getOrderBody().equals(other.getOrderBody()))
            && (this.getTrackingNo() == null ? other.getTrackingNo() == null : this.getTrackingNo().equals(other.getTrackingNo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getWareId() == null ? other.getWareId() == null : this.getWareId().equals(other.getWareId()))
            && (this.getTaskComment() == null ? other.getTaskComment() == null : this.getTaskComment().equals(other.getTaskComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getConsigneeTel() == null) ? 0 : getConsigneeTel().hashCode());
        result = prime * result + ((getDeliveryAddress() == null) ? 0 : getDeliveryAddress().hashCode());
        result = prime * result + ((getOrderComment() == null) ? 0 : getOrderComment().hashCode());
        result = prime * result + ((getPaymentWay() == null) ? 0 : getPaymentWay().hashCode());
        result = prime * result + ((getTaskStatus() == null) ? 0 : getTaskStatus().hashCode());
        result = prime * result + ((getOrderBody() == null) ? 0 : getOrderBody().hashCode());
        result = prime * result + ((getTrackingNo() == null) ? 0 : getTrackingNo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getWareId() == null) ? 0 : getWareId().hashCode());
        result = prime * result + ((getTaskComment() == null) ? 0 : getTaskComment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", consignee=").append(consignee);
        sb.append(", consigneeTel=").append(consigneeTel);
        sb.append(", deliveryAddress=").append(deliveryAddress);
        sb.append(", orderComment=").append(orderComment);
        sb.append(", paymentWay=").append(paymentWay);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", orderBody=").append(orderBody);
        sb.append(", trackingNo=").append(trackingNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", wareId=").append(wareId);
        sb.append(", taskComment=").append(taskComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}