package com.sxx.product.service;

import com.sxx.common.utils.PageUtils;
import com.sxx.product.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 针对表【pms_brand(品牌)】的数据库操作Service
 *
 * @author shenxianxin
 * @since 2021-12-02 18:42:19
 */
public interface BrandService extends IService<Brand> {

    /**
     * 列表查询
     *
     * @param params 查询参数
     * @return 列表
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 更新品牌
     *
     * @param brand 品牌信息
     */
    @Transactional(rollbackFor = Exception.class)
    void updateDetail(Brand brand);
}
