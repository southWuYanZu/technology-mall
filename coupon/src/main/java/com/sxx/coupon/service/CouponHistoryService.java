package com.sxx.coupon.service;

import com.sxx.coupon.entity.CouponHistory;
import com.sxx.common.utils.ResponseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_coupon_history(优惠券领取历史记录)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 23:45:42
*/
public interface CouponHistoryService extends IService<CouponHistory> {

    /**
     * 查询(优惠券领取历史记录)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
