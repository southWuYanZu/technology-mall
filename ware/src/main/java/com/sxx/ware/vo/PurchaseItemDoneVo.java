package com.sxx.ware.vo;

import lombok.Data;

/**
 * @author shenxianxin
 **/

@Data
public class PurchaseItemDoneVo {

    private Long itemId;

    private Integer status;

    private String reason;

}
