package com.sxx.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 秒杀活动商品关联
 * @TableName sms_seckill_sku_relation
 */
@TableName(value ="sms_seckill_sku_relation")
@Data
public class SeckillSkuRelation implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 活动id
     */
    @TableField(value = "promotion_id")
    private Long promotionId;

    /**
     * 活动场次id
     */
    @TableField(value = "promotion_session_id")
    private Long promotionSessionId;

    /**
     * 商品id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 秒杀价格
     */
    @TableField(value = "seckill_price")
    private Integer seckillPrice;

    /**
     * 秒杀总量
     */
    @TableField(value = "seckill_count")
    private Integer seckillCount;

    /**
     * 每人限购数量
     */
    @TableField(value = "seckill_limit")
    private Integer seckillLimit;

    /**
     * 排序
     */
    @TableField(value = "seckill_sort")
    private Integer seckillSort;

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
        SeckillSkuRelation other = (SeckillSkuRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPromotionId() == null ? other.getPromotionId() == null : this.getPromotionId().equals(other.getPromotionId()))
            && (this.getPromotionSessionId() == null ? other.getPromotionSessionId() == null : this.getPromotionSessionId().equals(other.getPromotionSessionId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getSeckillPrice() == null ? other.getSeckillPrice() == null : this.getSeckillPrice().equals(other.getSeckillPrice()))
            && (this.getSeckillCount() == null ? other.getSeckillCount() == null : this.getSeckillCount().equals(other.getSeckillCount()))
            && (this.getSeckillLimit() == null ? other.getSeckillLimit() == null : this.getSeckillLimit().equals(other.getSeckillLimit()))
            && (this.getSeckillSort() == null ? other.getSeckillSort() == null : this.getSeckillSort().equals(other.getSeckillSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPromotionId() == null) ? 0 : getPromotionId().hashCode());
        result = prime * result + ((getPromotionSessionId() == null) ? 0 : getPromotionSessionId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getSeckillPrice() == null) ? 0 : getSeckillPrice().hashCode());
        result = prime * result + ((getSeckillCount() == null) ? 0 : getSeckillCount().hashCode());
        result = prime * result + ((getSeckillLimit() == null) ? 0 : getSeckillLimit().hashCode());
        result = prime * result + ((getSeckillSort() == null) ? 0 : getSeckillSort().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", promotionId=").append(promotionId);
        sb.append(", promotionSessionId=").append(promotionSessionId);
        sb.append(", skuId=").append(skuId);
        sb.append(", seckillPrice=").append(seckillPrice);
        sb.append(", seckillCount=").append(seckillCount);
        sb.append(", seckillLimit=").append(seckillLimit);
        sb.append(", seckillSort=").append(seckillSort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}