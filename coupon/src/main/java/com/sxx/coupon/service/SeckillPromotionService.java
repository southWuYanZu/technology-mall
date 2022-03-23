package com.sxx.coupon.service;

import com.sxx.coupon.entity.SeckillPromotion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_seckill_promotion(秒杀活动)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 21:03:52
*/
public interface SeckillPromotionService extends IService<SeckillPromotion> {

    /**
     * 查询(秒杀活动)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
