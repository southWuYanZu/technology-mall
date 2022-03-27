package com.sxx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.SpuInfo;
import com.sxx.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * @author shenxianxin
 * 针对表【pms_spu_info(spu信息)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface SpuInfoService extends IService<SpuInfo> {

    /**
     * 查询(优惠券信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
    /**
     * 新增商品信息
     *
     * @param spuSaveVo 商品详情
     * @return 新增状态
     */
    ResponseEntity saveSpuInfo(SpuSaveVo spuSaveVo);
}
