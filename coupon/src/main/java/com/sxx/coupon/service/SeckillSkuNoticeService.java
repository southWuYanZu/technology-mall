package com.sxx.coupon.service;

import com.sxx.coupon.entity.SeckillSkuNotice;
import com.sxx.common.utils.ResponseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_seckill_sku_notice(秒杀商品通知订阅)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 23:45:42
*/
public interface SeckillSkuNoticeService extends IService<SeckillSkuNotice> {

    /**
     * 查询(秒杀商品通知订阅)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
