package com.sxx.coupon.service;

import com.sxx.coupon.entity.SkuLadder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_sku_ladder(商品阶梯价格)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 21:03:52
*/
public interface SkuLadderService extends IService<SkuLadder> {

    /**
     * 查询(商品阶梯价格)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
