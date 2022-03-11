package com.sxx.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.Purchase;

import java.util.Map;

/**
* 针对表【wms_purchase(采购信息)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-11 16:05:17
*/
public interface PurchaseService extends IService<Purchase> {

    /**
     * 查询wms_purchase(采购信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
