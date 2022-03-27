package com.sxx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.PageUtils;
import com.sxx.product.entity.SkuInfo;
import com.sxx.product.vo.SkuItemVo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author shenxianxin
 * 针对表【pms_sku_info(sku信息)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface SkuInfoService extends IService<SkuInfo> {

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return 分页集
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存方法
     *
     * @param skuInfoEntity skuInfo实体
     */
    void saveSkuInfo(SkuInfo skuInfoEntity);

    /**
     * 条件分页查询
     *
     * @param params 分页条件
     * @return 分页结果集
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取spu详细信息
     *
     * @param spuId spuId
     * @return spuInfo
     */
    List<SkuInfo> getSkusBySpuId(Long spuId);

    /**
     * 查询商品详情
     *
     * @param skuId skuId
     * @return 商品详情
     * @throws ExecutionException   ExecutionException
     * @throws InterruptedException InterruptedException
     */
    SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;
}
