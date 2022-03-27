package com.sxx.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.Purchase;
import com.sxx.ware.vo.MergeVo;
import com.sxx.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 针对表【wms_purchase(采购信息)】的数据库操作Service
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
public interface PurchaseService extends IService<Purchase> {

    /**
     * 查询(采购信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);

    /**
     * 查询未领取的采购单
     *
     * @param params 查询参数
     * @return 未领取的采购单
     */
    PageUtils queryPageUnReceive(Map<String, Object> params);

    /**
     * 合并采购需求
     *
     * @param mergeVo 合并信息
     */
    void mergePurchase(MergeVo mergeVo);

    /**
     * 领取采购单
     *
     * @param ids 采购单号
     */
    void received(List<Long> ids);

    /**
     * 完成采购单
     *
     * @param doneVo 采购单信息
     */
    void done(PurchaseDoneVo doneVo);
}
