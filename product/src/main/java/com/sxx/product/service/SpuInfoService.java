package com.sxx.product.service;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.SpuInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.product.vo.SpuSaveVo;

/**
 * @author shenxianxin
 * 针对表【pms_spu_info(spu信息)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface SpuInfoService extends IService<SpuInfo> {


    /**
     * 新增商品信息
     *
     * @param spuSaveVo 商品详情
     * @return 新增状态
     */
    ResponseEntity saveSpuInfo(SpuSaveVo spuSaveVo);
}
