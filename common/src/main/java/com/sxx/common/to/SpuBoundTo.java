package com.sxx.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shenxianxin
 */
@Data
public class SpuBoundTo {

    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
