package com.sxx.coupon.service;

import com.sxx.coupon.entity.CouponSpuRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_coupon_spu_relation(优惠券与产品关联)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 21:03:52
*/
public interface CouponSpuRelationService extends IService<CouponSpuRelation> {

    /**
     * 查询(优惠券与产品关联)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
