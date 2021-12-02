package com.sxx.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品评价
 * @TableName pms_spu_comment
 */
@TableName(value ="pms_spu_comment")
@Data
public class SpuComment implements Serializable {
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
     * spu_id
     */
    @TableField(value = "spu_id")
    private Long spuId;

    /**
     * 商品名字
     */
    @TableField(value = "spu_name")
    private String spuName;

    /**
     * 会员昵称
     */
    @TableField(value = "member_nick_name")
    private String memberNickName;

    /**
     * 星级
     */
    @TableField(value = "star")
    private Boolean star;

    /**
     * 会员ip
     */
    @TableField(value = "member_ip")
    private String memberIp;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 显示状态[0-不显示，1-显示]
     */
    @TableField(value = "show_status")
    private Boolean showStatus;

    /**
     * 购买时属性组合
     */
    @TableField(value = "spu_attributes")
    private String spuAttributes;

    /**
     * 点赞数
     */
    @TableField(value = "likes_count")
    private Integer likesCount;

    /**
     * 回复数
     */
    @TableField(value = "reply_count")
    private Integer replyCount;

    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @TableField(value = "resources")
    private String resources;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 用户头像
     */
    @TableField(value = "member_icon")
    private String memberIcon;

    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @TableField(value = "comment_type")
    private Byte commentType;

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
        SpuComment other = (SpuComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
            && (this.getSpuName() == null ? other.getSpuName() == null : this.getSpuName().equals(other.getSpuName()))
            && (this.getMemberNickName() == null ? other.getMemberNickName() == null : this.getMemberNickName().equals(other.getMemberNickName()))
            && (this.getStar() == null ? other.getStar() == null : this.getStar().equals(other.getStar()))
            && (this.getMemberIp() == null ? other.getMemberIp() == null : this.getMemberIp().equals(other.getMemberIp()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getShowStatus() == null ? other.getShowStatus() == null : this.getShowStatus().equals(other.getShowStatus()))
            && (this.getSpuAttributes() == null ? other.getSpuAttributes() == null : this.getSpuAttributes().equals(other.getSpuAttributes()))
            && (this.getLikesCount() == null ? other.getLikesCount() == null : this.getLikesCount().equals(other.getLikesCount()))
            && (this.getReplyCount() == null ? other.getReplyCount() == null : this.getReplyCount().equals(other.getReplyCount()))
            && (this.getResources() == null ? other.getResources() == null : this.getResources().equals(other.getResources()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getMemberIcon() == null ? other.getMemberIcon() == null : this.getMemberIcon().equals(other.getMemberIcon()))
            && (this.getCommentType() == null ? other.getCommentType() == null : this.getCommentType().equals(other.getCommentType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getSpuName() == null) ? 0 : getSpuName().hashCode());
        result = prime * result + ((getMemberNickName() == null) ? 0 : getMemberNickName().hashCode());
        result = prime * result + ((getStar() == null) ? 0 : getStar().hashCode());
        result = prime * result + ((getMemberIp() == null) ? 0 : getMemberIp().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getShowStatus() == null) ? 0 : getShowStatus().hashCode());
        result = prime * result + ((getSpuAttributes() == null) ? 0 : getSpuAttributes().hashCode());
        result = prime * result + ((getLikesCount() == null) ? 0 : getLikesCount().hashCode());
        result = prime * result + ((getReplyCount() == null) ? 0 : getReplyCount().hashCode());
        result = prime * result + ((getResources() == null) ? 0 : getResources().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getMemberIcon() == null) ? 0 : getMemberIcon().hashCode());
        result = prime * result + ((getCommentType() == null) ? 0 : getCommentType().hashCode());
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
        sb.append(", spuId=").append(spuId);
        sb.append(", spuName=").append(spuName);
        sb.append(", memberNickName=").append(memberNickName);
        sb.append(", star=").append(star);
        sb.append(", memberIp=").append(memberIp);
        sb.append(", createTime=").append(createTime);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", spuAttributes=").append(spuAttributes);
        sb.append(", likesCount=").append(likesCount);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", resources=").append(resources);
        sb.append(", content=").append(content);
        sb.append(", memberIcon=").append(memberIcon);
        sb.append(", commentType=").append(commentType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}