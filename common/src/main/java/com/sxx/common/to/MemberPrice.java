package com.sxx.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shenxianxin
 * @since 2022/3/22
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}