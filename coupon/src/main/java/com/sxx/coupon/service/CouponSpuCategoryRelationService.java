package com.sxx.coupon.service;

import com.sxx.coupon.entity.CouponSpuCategoryRelation;
import com.sxx.common.utils.ResponseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_coupon_spu_category_relation(优惠券分类关联)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 23:45:41
*/
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelation> {

    /**
     * 查询(优惠券分类关联)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
