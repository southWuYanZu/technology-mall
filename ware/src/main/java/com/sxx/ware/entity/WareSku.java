package com.sxx.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品库存
 * @TableName wms_ware_sku
 */
@TableName(value ="wms_ware_sku")
@Data
public class WareSku implements Serializable {
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
     * 仓库id
     */
    @TableField(value = "ware_id")
    private Long wareId;

    /**
     * 库存数
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * sku_name
     */
    @TableField(value = "sku_name")
    private String skuName;

    /**
     * 锁定库存
     */
    @TableField(value = "stock_locked")
    private Integer stockLocked;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}