package com.sxx.coupon.service;

import com.sxx.coupon.entity.HomeSubjectSpu;
import com.sxx.common.utils.ResponseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【sms_home_subject_spu(专题商品)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 23:45:42
*/
public interface HomeSubjectSpuService extends IService<HomeSubjectSpu> {

    /**
     * 查询(专题商品)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
