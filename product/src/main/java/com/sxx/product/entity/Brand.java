package com.sxx.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sxx.common.validate.AddGroup;
import com.sxx.common.validate.Status;
import com.sxx.common.validate.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 *
 * @author Mr.shen
 * @TableName pms_brand
 */
@TableName(value = "pms_brand")
@Data
public class Brand implements Serializable {

    /**
     * 品牌id
     */
    @TableId(value = "brand_id", type = IdType.AUTO)
    @Null(message = "新增不能携带ID", groups = AddGroup.class)
    @NotNull(message = "修改必须携带品牌ID", groups = UpdateGroup.class)
    private Long brandId;

    /**
     * 品牌名
     */
    @TableField(value = "name")
    @NotBlank(message = "品牌名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;

    /**
     * 品牌logo地址
     */
    @TableField(value = "logo")
    @NotEmpty(message = "品牌logo地址不能为空", groups = AddGroup.class)
    @URL(message = "logo必须是一个有效链接", groups = {AddGroup.class, UpdateGroup.class})
    private String logo;

    /**
     * 介绍
     */
    @TableField(value = "descript")
    @NotBlank(message = "介绍不能为空", groups = AddGroup.class)
    private String descript;

    /**
     * 显示状态[0-不显示；1-显示]
     */
    @TableField(value = "show_status")
    @NotNull(message = "状态值不能为空", groups = AddGroup.class)
    @Status(values = {0,1},groups = {AddGroup.class,UpdateGroup.class,Status.class})
    private Integer showStatus;

    /**
     * 检索首字母
     */
    @TableField(value = "first_letter")
    @Pattern(regexp = "^[a-zA-Z]$", message = "检索必须为一个字母", groups = AddGroup.class)
    private String firstLetter;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @NotNull(message = "排序不能为空", groups = AddGroup.class)
    private Integer sort;

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
        Brand other = (Brand) that;
        return (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
                && (this.getDescript() == null ? other.getDescript() == null : this.getDescript().equals(other.getDescript()))
                && (this.getShowStatus() == null ? other.getShowStatus() == null : this.getShowStatus().equals(other.getShowStatus()))
                && (this.getFirstLetter() == null ? other.getFirstLetter() == null : this.getFirstLetter().equals(other.getFirstLetter()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getDescript() == null) ? 0 : getDescript().hashCode());
        result = prime * result + ((getShowStatus() == null) ? 0 : getShowStatus().hashCode());
        result = prime * result + ((getFirstLetter() == null) ? 0 : getFirstLetter().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", brandId=" + brandId +
                ", name=" + name +
                ", logo=" + logo +
                ", description=" + descript +
                ", showStatus=" + showStatus +
                ", firstLetter=" + firstLetter +
                ", sort=" + sort +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}