package com.sxx.ware.vo;

import lombok.Data;

/**
 * @author shenxianxin
 **/

@Data
public class LockStockResultVo {

    private Long skuId;

    private Integer num;

    /** 是否锁定成功 **/
    private Boolean locked;

}
