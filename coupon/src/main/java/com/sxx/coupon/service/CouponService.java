package com.sxx.coupon.service;

import com.sxx.coupon.entity.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_coupon(优惠券信息)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 21:03:51
*/
public interface CouponService extends IService<Coupon> {

    /**
     * 查询(优惠券信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
