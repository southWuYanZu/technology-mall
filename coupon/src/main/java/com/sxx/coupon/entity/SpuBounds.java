package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品spu积分设置
 * @TableName sms_spu_bounds
 */
@TableName(value ="sms_spu_bounds")
@Data
public class SpuBounds implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    @TableField(value = "spu_id")
    private Long spuId;

    /**
     * 成长积分
     */
    @TableField(value = "grow_bounds")
    private BigDecimal growBounds;

    /**
     * 购物积分
     */
    @TableField(value = "buy_bounds")
    private BigDecimal buyBounds;

    /**
     * 优惠生效情况[1111（四个状态位，从右到左）;0 - 无优惠，成长积分是否赠送;1 - 无优惠，购物积分是否赠送;2 - 有优惠，成长积分是否赠送;3 - 有优惠，购物积分是否赠送【状态位0：不赠送，1：赠送】]
     */
    @TableField(value = "work")
    private Boolean work;

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
        SpuBounds other = (SpuBounds) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
            && (this.getGrowBounds() == null ? other.getGrowBounds() == null : this.getGrowBounds().equals(other.getGrowBounds()))
            && (this.getBuyBounds() == null ? other.getBuyBounds() == null : this.getBuyBounds().equals(other.getBuyBounds()))
            && (this.getWork() == null ? other.getWork() == null : this.getWork().equals(other.getWork()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getGrowBounds() == null) ? 0 : getGrowBounds().hashCode());
        result = prime * result + ((getBuyBounds() == null) ? 0 : getBuyBounds().hashCode());
        result = prime * result + ((getWork() == null) ? 0 : getWork().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", spuId=").append(spuId);
        sb.append(", growBounds=").append(growBounds);
        sb.append(", buyBounds=").append(buyBounds);
        sb.append(", work=").append(work);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}