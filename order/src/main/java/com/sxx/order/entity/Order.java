package com.sxx.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单
 * @TableName oms_order
 */
@TableName(value ="oms_order")
@Data
public class Order implements Serializable {
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
     * 订单号
     */
    @TableField(value = "order_sn")
    private String orderSn;

    /**
     * 使用的优惠券
     */
    @TableField(value = "coupon_id")
    private Long couponId;

    /**
     * create_time
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 用户名
     */
    @TableField(value = "member_username")
    private String memberUsername;

    /**
     * 订单总额
     */
    @TableField(value = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 应付总额
     */
    @TableField(value = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    @TableField(value = "freight_amount")
    private BigDecimal freightAmount;

    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    @TableField(value = "promotion_amount")
    private BigDecimal promotionAmount;

    /**
     * 积分抵扣金额
     */
    @TableField(value = "integration_amount")
    private BigDecimal integrationAmount;

    /**
     * 优惠券抵扣金额
     */
    @TableField(value = "coupon_amount")
    private BigDecimal couponAmount;

    /**
     * 后台调整订单使用的折扣金额
     */
    @TableField(value = "discount_amount")
    private BigDecimal discountAmount;

    /**
     * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
     */
    @TableField(value = "pay_type")
    private Byte payType;

    /**
     * 订单来源[0->PC订单；1->app订单]
     */
    @TableField(value = "source_type")
    private Byte sourceType;

    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    @TableField(value = "status")
    private Byte status;

    /**
     * 物流公司(配送方式)
     */
    @TableField(value = "delivery_company")
    private String deliveryCompany;

    /**
     * 物流单号
     */
    @TableField(value = "delivery_sn")
    private String deliverySn;

    /**
     * 自动确认时间（天）
     */
    @TableField(value = "auto_confirm_day")
    private Integer autoConfirmDay;

    /**
     * 可以获得的积分
     */
    @TableField(value = "integration")
    private Integer integration;

    /**
     * 可以获得的成长值
     */
    @TableField(value = "growth")
    private Integer growth;

    /**
     * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
     */
    @TableField(value = "bill_type")
    private Byte billType;

    /**
     * 发票抬头
     */
    @TableField(value = "bill_header")
    private String billHeader;

    /**
     * 发票内容
     */
    @TableField(value = "bill_content")
    private String billContent;

    /**
     * 收票人电话
     */
    @TableField(value = "bill_receiver_phone")
    private String billReceiverPhone;

    /**
     * 收票人邮箱
     */
    @TableField(value = "bill_receiver_email")
    private String billReceiverEmail;

    /**
     * 收货人姓名
     */
    @TableField(value = "receiver_name")
    private String receiverName;

    /**
     * 收货人电话
     */
    @TableField(value = "receiver_phone")
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    @TableField(value = "receiver_post_code")
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    @TableField(value = "receiver_province")
    private String receiverProvince;

    /**
     * 城市
     */
    @TableField(value = "receiver_city")
    private String receiverCity;

    /**
     * 区
     */
    @TableField(value = "receiver_region")
    private String receiverRegion;

    /**
     * 详细地址
     */
    @TableField(value = "receiver_detail_address")
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    @TableField(value = "note")
    private String note;

    /**
     * 确认收货状态[0->未确认；1->已确认]
     */
    @TableField(value = "confirm_status")
    private Byte confirmStatus;

    /**
     * 删除状态【0->未删除；1->已删除】
     */
    @TableField(value = "delete_status")
    private Byte deleteStatus;

    /**
     * 下单时使用的积分
     */
    @TableField(value = "use_integration")
    private Integer useIntegration;

    /**
     * 支付时间
     */
    @TableField(value = "payment_time")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @TableField(value = "delivery_time")
    private Date deliveryTime;

    /**
     * 确认收货时间
     */
    @TableField(value = "receive_time")
    private Date receiveTime;

    /**
     * 评价时间
     */
    @TableField(value = "comment_time")
    private Date commentTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time")
    private Date modifyTime;

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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getMemberUsername() == null ? other.getMemberUsername() == null : this.getMemberUsername().equals(other.getMemberUsername()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getFreightAmount() == null ? other.getFreightAmount() == null : this.getFreightAmount().equals(other.getFreightAmount()))
            && (this.getPromotionAmount() == null ? other.getPromotionAmount() == null : this.getPromotionAmount().equals(other.getPromotionAmount()))
            && (this.getIntegrationAmount() == null ? other.getIntegrationAmount() == null : this.getIntegrationAmount().equals(other.getIntegrationAmount()))
            && (this.getCouponAmount() == null ? other.getCouponAmount() == null : this.getCouponAmount().equals(other.getCouponAmount()))
            && (this.getDiscountAmount() == null ? other.getDiscountAmount() == null : this.getDiscountAmount().equals(other.getDiscountAmount()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeliveryCompany() == null ? other.getDeliveryCompany() == null : this.getDeliveryCompany().equals(other.getDeliveryCompany()))
            && (this.getDeliverySn() == null ? other.getDeliverySn() == null : this.getDeliverySn().equals(other.getDeliverySn()))
            && (this.getAutoConfirmDay() == null ? other.getAutoConfirmDay() == null : this.getAutoConfirmDay().equals(other.getAutoConfirmDay()))
            && (this.getIntegration() == null ? other.getIntegration() == null : this.getIntegration().equals(other.getIntegration()))
            && (this.getGrowth() == null ? other.getGrowth() == null : this.getGrowth().equals(other.getGrowth()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getBillHeader() == null ? other.getBillHeader() == null : this.getBillHeader().equals(other.getBillHeader()))
            && (this.getBillContent() == null ? other.getBillContent() == null : this.getBillContent().equals(other.getBillContent()))
            && (this.getBillReceiverPhone() == null ? other.getBillReceiverPhone() == null : this.getBillReceiverPhone().equals(other.getBillReceiverPhone()))
            && (this.getBillReceiverEmail() == null ? other.getBillReceiverEmail() == null : this.getBillReceiverEmail().equals(other.getBillReceiverEmail()))
            && (this.getReceiverName() == null ? other.getReceiverName() == null : this.getReceiverName().equals(other.getReceiverName()))
            && (this.getReceiverPhone() == null ? other.getReceiverPhone() == null : this.getReceiverPhone().equals(other.getReceiverPhone()))
            && (this.getReceiverPostCode() == null ? other.getReceiverPostCode() == null : this.getReceiverPostCode().equals(other.getReceiverPostCode()))
            && (this.getReceiverProvince() == null ? other.getReceiverProvince() == null : this.getReceiverProvince().equals(other.getReceiverProvince()))
            && (this.getReceiverCity() == null ? other.getReceiverCity() == null : this.getReceiverCity().equals(other.getReceiverCity()))
            && (this.getReceiverRegion() == null ? other.getReceiverRegion() == null : this.getReceiverRegion().equals(other.getReceiverRegion()))
            && (this.getReceiverDetailAddress() == null ? other.getReceiverDetailAddress() == null : this.getReceiverDetailAddress().equals(other.getReceiverDetailAddress()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()))
            && (this.getUseIntegration() == null ? other.getUseIntegration() == null : this.getUseIntegration().equals(other.getUseIntegration()))
            && (this.getPaymentTime() == null ? other.getPaymentTime() == null : this.getPaymentTime().equals(other.getPaymentTime()))
            && (this.getDeliveryTime() == null ? other.getDeliveryTime() == null : this.getDeliveryTime().equals(other.getDeliveryTime()))
            && (this.getReceiveTime() == null ? other.getReceiveTime() == null : this.getReceiveTime().equals(other.getReceiveTime()))
            && (this.getCommentTime() == null ? other.getCommentTime() == null : this.getCommentTime().equals(other.getCommentTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getMemberUsername() == null) ? 0 : getMemberUsername().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getFreightAmount() == null) ? 0 : getFreightAmount().hashCode());
        result = prime * result + ((getPromotionAmount() == null) ? 0 : getPromotionAmount().hashCode());
        result = prime * result + ((getIntegrationAmount() == null) ? 0 : getIntegrationAmount().hashCode());
        result = prime * result + ((getCouponAmount() == null) ? 0 : getCouponAmount().hashCode());
        result = prime * result + ((getDiscountAmount() == null) ? 0 : getDiscountAmount().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeliveryCompany() == null) ? 0 : getDeliveryCompany().hashCode());
        result = prime * result + ((getDeliverySn() == null) ? 0 : getDeliverySn().hashCode());
        result = prime * result + ((getAutoConfirmDay() == null) ? 0 : getAutoConfirmDay().hashCode());
        result = prime * result + ((getIntegration() == null) ? 0 : getIntegration().hashCode());
        result = prime * result + ((getGrowth() == null) ? 0 : getGrowth().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getBillHeader() == null) ? 0 : getBillHeader().hashCode());
        result = prime * result + ((getBillContent() == null) ? 0 : getBillContent().hashCode());
        result = prime * result + ((getBillReceiverPhone() == null) ? 0 : getBillReceiverPhone().hashCode());
        result = prime * result + ((getBillReceiverEmail() == null) ? 0 : getBillReceiverEmail().hashCode());
        result = prime * result + ((getReceiverName() == null) ? 0 : getReceiverName().hashCode());
        result = prime * result + ((getReceiverPhone() == null) ? 0 : getReceiverPhone().hashCode());
        result = prime * result + ((getReceiverPostCode() == null) ? 0 : getReceiverPostCode().hashCode());
        result = prime * result + ((getReceiverProvince() == null) ? 0 : getReceiverProvince().hashCode());
        result = prime * result + ((getReceiverCity() == null) ? 0 : getReceiverCity().hashCode());
        result = prime * result + ((getReceiverRegion() == null) ? 0 : getReceiverRegion().hashCode());
        result = prime * result + ((getReceiverDetailAddress() == null) ? 0 : getReceiverDetailAddress().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getUseIntegration() == null) ? 0 : getUseIntegration().hashCode());
        result = prime * result + ((getPaymentTime() == null) ? 0 : getPaymentTime().hashCode());
        result = prime * result + ((getDeliveryTime() == null) ? 0 : getDeliveryTime().hashCode());
        result = prime * result + ((getReceiveTime() == null) ? 0 : getReceiveTime().hashCode());
        result = prime * result + ((getCommentTime() == null) ? 0 : getCommentTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", couponId=").append(couponId);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberUsername=").append(memberUsername);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", freightAmount=").append(freightAmount);
        sb.append(", promotionAmount=").append(promotionAmount);
        sb.append(", integrationAmount=").append(integrationAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", payType=").append(payType);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", status=").append(status);
        sb.append(", deliveryCompany=").append(deliveryCompany);
        sb.append(", deliverySn=").append(deliverySn);
        sb.append(", autoConfirmDay=").append(autoConfirmDay);
        sb.append(", integration=").append(integration);
        sb.append(", growth=").append(growth);
        sb.append(", billType=").append(billType);
        sb.append(", billHeader=").append(billHeader);
        sb.append(", billContent=").append(billContent);
        sb.append(", billReceiverPhone=").append(billReceiverPhone);
        sb.append(", billReceiverEmail=").append(billReceiverEmail);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", receiverPostCode=").append(receiverPostCode);
        sb.append(", receiverProvince=").append(receiverProvince);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverRegion=").append(receiverRegion);
        sb.append(", receiverDetailAddress=").append(receiverDetailAddress);
        sb.append(", note=").append(note);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", useIntegration=").append(useIntegration);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", deliveryTime=").append(deliveryTime);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}