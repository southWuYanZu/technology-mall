package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.SpuImages;
import com.sxx.product.entity.SpuInfo;
import com.sxx.product.entity.SpuInfoDesc;
import com.sxx.product.mapper.SpuInfoMapper;
import com.sxx.product.service.SpuImagesService;
import com.sxx.product.service.SpuInfoDescService;
import com.sxx.product.service.SpuInfoService;
import com.sxx.product.vo.Images;
import com.sxx.product.vo.SpuSaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenxianxin
 * 针对表【pms_spu_info(spu信息)】的数据库操作Service实现
 * @since 2021-12-02 18:42:19
 */
@Service
@RequiredArgsConstructor
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo>
        implements SpuInfoService {

    private final SpuInfoDescService descService;

    private final SpuImagesService imagesService;

    @Override
    public ResponseEntity saveSpuInfo(SpuSaveVo spuSaveVo) {
        //保存spuInfo信息
        SpuInfo spuInfo = new SpuInfo();
        BeanUtils.copyProperties(spuSaveVo, spuInfo);
        spuInfo.setCreateTime(new Date());
        spuInfo.setUpdateTime(new Date());
        this.save(spuInfo);
        //保存spu描述图片信息
        List<String> description = spuSaveVo.getDecript();
        SpuInfoDesc desc = new SpuInfoDesc();
        desc.setSpuId(spuInfo.getId());
        desc.setDecript(String.join(",", description));
        descService.save(desc);
        //保存spu的图片集
        spuSaveVo.getSkus().forEach(item -> {
            List<Images> images = item.getImages();
            List<SpuImages> spuImagesList = images.stream().map(image -> {
                SpuImages spuImages = new SpuImages();
                spuImages.setImgUrl(image.getImgUrl());
                spuImages.setDefaultImg(image.getDefaultImg());
                spuImages.setSpuId(spuInfo.getId());
                spuImages.setImgName(item.getSkuTitle());
                return spuImages;
            }).collect(Collectors.toList());
            imagesService.saveBatch(spuImagesList);
        });
        //保存sku信息
        return null;
    }
}




