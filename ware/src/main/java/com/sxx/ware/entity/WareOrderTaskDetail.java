package com.sxx.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 库存工作单
 * @TableName wms_ware_order_task_detail
 */
@TableName(value ="wms_ware_order_task_detail")
@Data
public class WareOrderTaskDetail implements Serializable {
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
     * sku_name
     */
    @TableField(value = "sku_name")
    private String skuName;

    /**
     * 购买个数
     */
    @TableField(value = "sku_num")
    private Integer skuNum;

    /**
     * 工作单id
     */
    @TableField(value = "task_id")
    private Long taskId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}