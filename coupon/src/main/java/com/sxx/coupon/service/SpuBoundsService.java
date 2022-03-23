package com.sxx.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SpuBounds;

import java.util.Map;

/**
* 针对表【sms_spu_bounds(商品spu积分设置)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 21:03:52
*/
public interface SpuBoundsService extends IService<SpuBounds> {

    /**
     * 查询(商品spu积分设置)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
