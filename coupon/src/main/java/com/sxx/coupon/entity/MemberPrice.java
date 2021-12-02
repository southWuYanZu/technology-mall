package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品会员价格
 * @TableName sms_member_price
 */
@TableName(value ="sms_member_price")
@Data
public class MemberPrice implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 会员等级id
     */
    @TableField(value = "member_level_id")
    private Long memberLevelId;

    /**
     * 会员等级名
     */
    @TableField(value = "member_level_name")
    private String memberLevelName;

    /**
     * 会员对应价格
     */
    @TableField(value = "member_price")
    private BigDecimal memberPrice;

    /**
     * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
     */
    @TableField(value = "add_other")
    private Boolean addOther;

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
        MemberPrice other = (MemberPrice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getMemberLevelId() == null ? other.getMemberLevelId() == null : this.getMemberLevelId().equals(other.getMemberLevelId()))
            && (this.getMemberLevelName() == null ? other.getMemberLevelName() == null : this.getMemberLevelName().equals(other.getMemberLevelName()))
            && (this.getMemberPrice() == null ? other.getMemberPrice() == null : this.getMemberPrice().equals(other.getMemberPrice()))
            && (this.getAddOther() == null ? other.getAddOther() == null : this.getAddOther().equals(other.getAddOther()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getMemberLevelId() == null) ? 0 : getMemberLevelId().hashCode());
        result = prime * result + ((getMemberLevelName() == null) ? 0 : getMemberLevelName().hashCode());
        result = prime * result + ((getMemberPrice() == null) ? 0 : getMemberPrice().hashCode());
        result = prime * result + ((getAddOther() == null) ? 0 : getAddOther().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", skuId=").append(skuId);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", memberLevelName=").append(memberLevelName);
        sb.append(", memberPrice=").append(memberPrice);
        sb.append(", addOther=").append(addOther);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}