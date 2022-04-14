package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.SkuImages;
import com.sxx.product.mapper.SkuImagesMapper;
import com.sxx.product.service.SkuImagesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shenxianxin
*  针对表【pms_sku_images(sku图片)】的数据库操作Service实现
* @since 2021-12-02 18:42:19
*/
@Service
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesMapper, SkuImages>
    implements SkuImagesService{

    @Override
    public List<SkuImages> getImagesBySkuId(Long skuId) {

        return this.baseMapper.selectList(new QueryWrapper<SkuImages>().eq("sku_id", skuId));

    }

}




