package com.sxx.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName wms_purchase_detail
 */
@TableName(value ="wms_purchase_detail")
@Data
public class PurchaseDetail implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购单id
     */
    @TableField(value = "purchase_id")
    private Long purchaseId;

    /**
     * 采购商品id
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 采购数量
     */
    @TableField(value = "sku_num")
    private Integer skuNum;

    /**
     * 采购金额
     */
    @TableField(value = "sku_price")
    private BigDecimal skuPrice;

    /**
     * 仓库id
     */
    @TableField(value = "ware_id")
    private Long wareId;

    /**
     * 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}