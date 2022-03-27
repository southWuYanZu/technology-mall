package com.sxx.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.to.SkuReductionTo;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SkuFullReduction;

import java.util.Map;

/**
* 针对表【sms_sku_full_reduction(商品满减信息)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-23 23:37:02
*/
public interface SkuFullReductionService extends IService<SkuFullReduction> {

    /**
     * 查询(商品满减信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);

    /**
     * 发布商品保存sku 满减信息
     *
     * @param skuReductionTo (商品满减信息)信息
     */
    void saveSkuReduction(SkuReductionTo skuReductionTo);
}
