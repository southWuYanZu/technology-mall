package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.CouponHistory;
import com.sxx.coupon.service.CouponHistoryService;
import com.sxx.coupon.mapper.CouponHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【sms_coupon_history(优惠券领取历史记录)】的数据库操作Service实现
* @since 2021-12-02 18:49:16
*/
@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistory>
    implements CouponHistoryService{

}




