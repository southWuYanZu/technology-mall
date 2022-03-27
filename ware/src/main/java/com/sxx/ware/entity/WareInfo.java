package com.sxx.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 仓库信息
 * @TableName wms_ware_info
 */
@TableName(value ="wms_ware_info")
@Data
public class WareInfo implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 仓库地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 区域编码
     */
    @TableField(value = "areacode")
    private String areacode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}