package com.sxx.common.to.mq;

import lombok.Data;

/**
 * @author shenxianxin
 * @since 2022/4/2
 **/
@Data
public class StockLockedTo {

    /** 库存工作单的id **/
    private Long id;

    /** 工作单详情的所有信息 **/
    private StockDetailTo detailTo;
}
