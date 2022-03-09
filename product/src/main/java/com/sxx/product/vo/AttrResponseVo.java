package com.sxx.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Mr.shen
 * @since 2022/03/08 下午 9:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrResponseVo extends AttrVo {

    /**
     * 分组名称
     */
    private String attrGroupName;

    /**
     * 分类名字
     */
    private String catelogName;

    /**
     * 分类全路径
     */
    private Long[] catelogPath;
    private static final long serialVersionUID = 1L;

}

