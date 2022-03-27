package com.sxx.coupon.service;

import com.sxx.coupon.entity.HomeAdv;
import com.sxx.common.utils.ResponseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_home_adv(首页轮播广告)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 23:45:42
*/
public interface HomeAdvService extends IService<HomeAdv> {

    /**
     * 查询(首页轮播广告)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
