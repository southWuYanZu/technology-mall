package com.sxx.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * spu图片
 *
 * @author Mr.shen
 * @TableName pms_spu_images
 */
@TableName(value = "pms_spu_images")
@Data
public class SpuImages implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu_id
     */
    @TableField(value = "spu_id")
    private Long spuId;

    /**
     * 图片名
     */
    @TableField(value = "img_name")
    private String imgName;

    /**
     * 图片地址
     */
    @TableField(value = "img_url")
    private String imgUrl;

    /**
     * 顺序
     */
    @TableField(value = "img_sort")
    private Integer imgSort;

    /**
     * 是否默认图
     */
    @TableField(value = "default_img")
    private Byte defaultImg;

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
        SpuImages other = (SpuImages) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
                && (this.getImgName() == null ? other.getImgName() == null : this.getImgName().equals(other.getImgName()))
                && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
                && (this.getImgSort() == null ? other.getImgSort() == null : this.getImgSort().equals(other.getImgSort()))
                && (this.getDefaultImg() == null ? other.getDefaultImg() == null : this.getDefaultImg().equals(other.getDefaultImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getImgName() == null) ? 0 : getImgName().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getImgSort() == null) ? 0 : getImgSort().hashCode());
        result = prime * result + ((getDefaultImg() == null) ? 0 : getDefaultImg().hashCode());
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
        sb.append(", imgName=").append(imgName);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", imgSort=").append(imgSort);
        sb.append(", defaultImg=").append(defaultImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}