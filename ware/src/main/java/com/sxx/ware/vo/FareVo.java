package com.sxx.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shenxianxin
 **/

@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}


