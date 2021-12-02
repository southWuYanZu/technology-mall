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
 * 订单退货申请
 * @TableName oms_order_return_apply
 */
@TableName(value ="oms_order_return_apply")
@Data
public class OrderReturnApply implements Serializable {
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
     * 退货商品id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 订单编号
     */
    @TableField(value = "order_sn")
    private String orderSn;

    /**
     * 申请时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 会员用户名
     */
    @TableField(value = "member_username")
    private String memberUsername;

    /**
     * 退款金额
     */
    @TableField(value = "return_amount")
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    @TableField(value = "return_name")
    private String returnName;

    /**
     * 退货人电话
     */
    @TableField(value = "return_phone")
    private String returnPhone;

    /**
     * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
     */
    @TableField(value = "status")
    private Boolean status;

    /**
     * 处理时间
     */
    @TableField(value = "handle_time")
    private Date handleTime;

    /**
     * 商品图片
     */
    @TableField(value = "sku_img")
    private String skuImg;

    /**
     * 商品名称
     */
    @TableField(value = "sku_name")
    private String skuName;

    /**
     * 商品品牌
     */
    @TableField(value = "sku_brand")
    private String skuBrand;

    /**
     * 商品销售属性(JSON)
     */
    @TableField(value = "sku_attrs_vals")
    private String skuAttrsVals;

    /**
     * 退货数量
     */
    @TableField(value = "sku_count")
    private Integer skuCount;

    /**
     * 商品单价
     */
    @TableField(value = "sku_price")
    private BigDecimal skuPrice;

    /**
     * 商品实际支付单价
     */
    @TableField(value = "sku_real_price")
    private BigDecimal skuRealPrice;

    /**
     * 原因
     */
    @TableField(value = "reason")
    private String reason;

    /**
     * 描述
     */
    @TableField(value = "description述")
    private String description述;

    /**
     * 凭证图片，以逗号隔开
     */
    @TableField(value = "desc_pics")
    private String descPics;

    /**
     * 处理备注
     */
    @TableField(value = "handle_note")
    private String handleNote;

    /**
     * 处理人员
     */
    @TableField(value = "handle_man")
    private String handleMan;

    /**
     * 收货人
     */
    @TableField(value = "receive_man")
    private String receiveMan;

    /**
     * 收货时间
     */
    @TableField(value = "receive_time")
    private Date receiveTime;

    /**
     * 收货备注
     */
    @TableField(value = "receive_note")
    private String receiveNote;

    /**
     * 收货电话
     */
    @TableField(value = "receive_phone")
    private String receivePhone;

    /**
     * 公司收货地址
     */
    @TableField(value = "company_address")
    private String companyAddress;

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
        OrderReturnApply other = (OrderReturnApply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getMemberUsername() == null ? other.getMemberUsername() == null : this.getMemberUsername().equals(other.getMemberUsername()))
            && (this.getReturnAmount() == null ? other.getReturnAmount() == null : this.getReturnAmount().equals(other.getReturnAmount()))
            && (this.getReturnName() == null ? other.getReturnName() == null : this.getReturnName().equals(other.getReturnName()))
            && (this.getReturnPhone() == null ? other.getReturnPhone() == null : this.getReturnPhone().equals(other.getReturnPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHandleTime() == null ? other.getHandleTime() == null : this.getHandleTime().equals(other.getHandleTime()))
            && (this.getSkuImg() == null ? other.getSkuImg() == null : this.getSkuImg().equals(other.getSkuImg()))
            && (this.getSkuName() == null ? other.getSkuName() == null : this.getSkuName().equals(other.getSkuName()))
            && (this.getSkuBrand() == null ? other.getSkuBrand() == null : this.getSkuBrand().equals(other.getSkuBrand()))
            && (this.getSkuAttrsVals() == null ? other.getSkuAttrsVals() == null : this.getSkuAttrsVals().equals(other.getSkuAttrsVals()))
            && (this.getSkuCount() == null ? other.getSkuCount() == null : this.getSkuCount().equals(other.getSkuCount()))
            && (this.getSkuPrice() == null ? other.getSkuPrice() == null : this.getSkuPrice().equals(other.getSkuPrice()))
            && (this.getSkuRealPrice() == null ? other.getSkuRealPrice() == null : this.getSkuRealPrice().equals(other.getSkuRealPrice()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getDescription述() == null ? other.getDescription述() == null : this.getDescription述().equals(other.getDescription述()))
            && (this.getDescPics() == null ? other.getDescPics() == null : this.getDescPics().equals(other.getDescPics()))
            && (this.getHandleNote() == null ? other.getHandleNote() == null : this.getHandleNote().equals(other.getHandleNote()))
            && (this.getHandleMan() == null ? other.getHandleMan() == null : this.getHandleMan().equals(other.getHandleMan()))
            && (this.getReceiveMan() == null ? other.getReceiveMan() == null : this.getReceiveMan().equals(other.getReceiveMan()))
            && (this.getReceiveTime() == null ? other.getReceiveTime() == null : this.getReceiveTime().equals(other.getReceiveTime()))
            && (this.getReceiveNote() == null ? other.getReceiveNote() == null : this.getReceiveNote().equals(other.getReceiveNote()))
            && (this.getReceivePhone() == null ? other.getReceivePhone() == null : this.getReceivePhone().equals(other.getReceivePhone()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getMemberUsername() == null) ? 0 : getMemberUsername().hashCode());
        result = prime * result + ((getReturnAmount() == null) ? 0 : getReturnAmount().hashCode());
        result = prime * result + ((getReturnName() == null) ? 0 : getReturnName().hashCode());
        result = prime * result + ((getReturnPhone() == null) ? 0 : getReturnPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHandleTime() == null) ? 0 : getHandleTime().hashCode());
        result = prime * result + ((getSkuImg() == null) ? 0 : getSkuImg().hashCode());
        result = prime * result + ((getSkuName() == null) ? 0 : getSkuName().hashCode());
        result = prime * result + ((getSkuBrand() == null) ? 0 : getSkuBrand().hashCode());
        result = prime * result + ((getSkuAttrsVals() == null) ? 0 : getSkuAttrsVals().hashCode());
        result = prime * result + ((getSkuCount() == null) ? 0 : getSkuCount().hashCode());
        result = prime * result + ((getSkuPrice() == null) ? 0 : getSkuPrice().hashCode());
        result = prime * result + ((getSkuRealPrice() == null) ? 0 : getSkuRealPrice().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getDescription述() == null) ? 0 : getDescription述().hashCode());
        result = prime * result + ((getDescPics() == null) ? 0 : getDescPics().hashCode());
        result = prime * result + ((getHandleNote() == null) ? 0 : getHandleNote().hashCode());
        result = prime * result + ((getHandleMan() == null) ? 0 : getHandleMan().hashCode());
        result = prime * result + ((getReceiveMan() == null) ? 0 : getReceiveMan().hashCode());
        result = prime * result + ((getReceiveTime() == null) ? 0 : getReceiveTime().hashCode());
        result = prime * result + ((getReceiveNote() == null) ? 0 : getReceiveNote().hashCode());
        result = prime * result + ((getReceivePhone() == null) ? 0 : getReceivePhone().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
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
        sb.append(", skuId=").append(skuId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberUsername=").append(memberUsername);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", returnName=").append(returnName);
        sb.append(", returnPhone=").append(returnPhone);
        sb.append(", status=").append(status);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", skuImg=").append(skuImg);
        sb.append(", skuName=").append(skuName);
        sb.append(", skuBrand=").append(skuBrand);
        sb.append(", skuAttrsVals=").append(skuAttrsVals);
        sb.append(", skuCount=").append(skuCount);
        sb.append(", skuPrice=").append(skuPrice);
        sb.append(", skuRealPrice=").append(skuRealPrice);
        sb.append(", reason=").append(reason);
        sb.append(", description述=").append(description述);
        sb.append(", descPics=").append(descPics);
        sb.append(", handleNote=").append(handleNote);
        sb.append(", handleMan=").append(handleMan);
        sb.append(", receiveMan=").append(receiveMan);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", receiveNote=").append(receiveNote);
        sb.append(", receivePhone=").append(receivePhone);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}