package com.sxx.product.vo;

import lombok.Data;

/**
 * @author Mr.shen
 * @since 2022/03/12 上午 11:23
 */

@Data
public class AttrRespVo extends AttrVo {

    /**
     *
     */
    private String catelogName;

    private String groupName;

    private Long[] catelogPath;

}
