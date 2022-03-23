package com.sxx.coupon.service;

import com.sxx.coupon.entity.SeckillSession;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_seckill_session(秒杀活动场次)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 21:03:52
*/
public interface SeckillSessionService extends IService<SeckillSession> {

    /**
     * 查询(秒杀活动场次)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
