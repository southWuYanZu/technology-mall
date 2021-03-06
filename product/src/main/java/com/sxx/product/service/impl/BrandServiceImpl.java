package com.sxx.product.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.product.entity.Brand;
import com.sxx.product.enums.ProConsEnums;
import com.sxx.product.mapper.BrandMapper;
import com.sxx.product.service.BrandService;
import com.sxx.product.service.CategoryBrandRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 针对表【pms_brand(品牌)】的数据库操作Service实现
 *
 * @author shenxianxin
 * @since 2021-12-02 18:42:19
 */
@Service
@RequiredArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
        implements BrandService {

    private final CategoryBrandRelationService relationService;

    /**
     * 列表查询
     *
     * @param params 查询参数
     * @return 列表
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //1、获取key
        String key = (String) params.get("key");
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq(ProConsEnums.COLUMN_BRAND_ID, key).or().like(ProConsEnums.COLUMN_NAME, key)
                    .or().eq(ProConsEnums.COLUMN_FIRST_LETTER, key);
        }
        IPage<Brand> page = this.page(
                new Query<Brand>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }


    /**
     * 更新品牌
     *
     * @param brand 品牌信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDetail(Brand brand) {
        //TODO 保证冗余字段的数据一致
        this.updateById(brand);
        String brandName = brand.getName();
        if (!StringUtils.isEmpty(brandName)) {
            //更新关联表品牌信息
            relationService.updateBrandName(brand.getBrandId(), brandName);
        }
    }
}




