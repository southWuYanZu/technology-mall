package com.sxx.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author shenxianxin
 **/

@Data
public class MergeVo {

    private Long purchaseId;

    private List<Long> items;

}
