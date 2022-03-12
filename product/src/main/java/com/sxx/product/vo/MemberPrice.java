package com.sxx.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Mr.shen
 * @since 2022/03/12 上午 11:23
 */

@Data
public class MemberPrice {

  private Long id;
  private String name;
  private BigDecimal price;

}
