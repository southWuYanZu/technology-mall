package com.sxx.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 会员收藏的专题活动
 * @TableName ums_member_collect_subject
 */
@TableName(value ="ums_member_collect_subject")
@Data
public class MemberCollectSubject implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * subject_id
     */
    @TableField(value = "subject_id")
    private Long subjectId;

    /**
     * subject_name
     */
    @TableField(value = "subject_name")
    private String subjectName;

    /**
     * subject_img
     */
    @TableField(value = "subject_img")
    private String subjectImg;

    /**
     * 活动url
     */
    @TableField(value = "subject_urll")
    private String subjectUrll;

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
        MemberCollectSubject other = (MemberCollectSubject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSubjectId() == null ? other.getSubjectId() == null : this.getSubjectId().equals(other.getSubjectId()))
            && (this.getSubjectName() == null ? other.getSubjectName() == null : this.getSubjectName().equals(other.getSubjectName()))
            && (this.getSubjectImg() == null ? other.getSubjectImg() == null : this.getSubjectImg().equals(other.getSubjectImg()))
            && (this.getSubjectUrll() == null ? other.getSubjectUrll() == null : this.getSubjectUrll().equals(other.getSubjectUrll()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        result = prime * result + ((getSubjectName() == null) ? 0 : getSubjectName().hashCode());
        result = prime * result + ((getSubjectImg() == null) ? 0 : getSubjectImg().hashCode());
        result = prime * result + ((getSubjectUrll() == null) ? 0 : getSubjectUrll().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", subjectName=").append(subjectName);
        sb.append(", subjectImg=").append(subjectImg);
        sb.append(", subjectUrll=").append(subjectUrll);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}