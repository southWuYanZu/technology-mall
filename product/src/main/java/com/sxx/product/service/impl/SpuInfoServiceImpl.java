package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.to.SkuReductionTo;
import com.sxx.common.to.SpuBoundTo;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.*;
import com.sxx.product.enums.ProConsEnums;
import com.sxx.product.feign.CouponFeignClient;
import com.sxx.product.mapper.SpuInfoMapper;
import com.sxx.product.service.*;
import com.sxx.product.vo.BaseAttrs;
import com.sxx.product.vo.Bounds;
import com.sxx.product.vo.Images;
import com.sxx.product.vo.SpuSaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
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

    private final AttrService attrService;

    private final SpuInfoDescService descService;

    private final SkuInfoService skuInfoService;

    private final SpuImagesService spuImagesService;

    private final SkuImagesService skuImagesService;

    private final CouponFeignClient couponFeignClient;

    private final SkuSaleAttrValueService skuSaleAttrValueService;

    private final ProductAttrValueService productAttrValueService;

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SpuInfo> query = new Query<>();
        QueryWrapper<SpuInfo> wrapper = new QueryWrapper<>();

        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.and(condition -> condition.eq(ProConsEnums.COLUMN_ID,key).or().like(ProConsEnums.COLUMN_SPU_NAME,key));
        }

        String status = (String) params.get("status");
        if (!StringUtils.isEmpty(status)) {
            wrapper.eq(ProConsEnums.COLUMN_STATUS,status);
        }
        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId) && !ProConsEnums.STR_ZERO.equalsIgnoreCase(brandId)) {
            wrapper.eq(ProConsEnums.COLUMN_BRAND_ID,brandId);
        }

        String catelogId = (String) params.get("catelogId");
        if (!StringUtils.isEmpty(catelogId) && !ProConsEnums.STR_ZERO.equalsIgnoreCase(catelogId)) {
            wrapper.eq(ProConsEnums.COLUMN_CATELOG_ID,catelogId);
        }
        IPage<SpuInfo> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }

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
        //保存spu图片集
        List<String> spuImages = spuSaveVo.getImages();
        List<SpuImages> spuImagesList = spuImages.stream().map(image -> {
            SpuImages spuImg = new SpuImages();
            spuImg.setSpuId(spuInfo.getId());
            spuImg.setImgUrl(image);
            return spuImg;
        }).collect(Collectors.toList());
        spuImagesService.saveBatch(spuImagesList);
        //保存sku的图片集 和 skuInfo信息 和sku得销售信息
        saveSkuInfo(spuSaveVo,spuInfo);
        //保存spu信息
        List<BaseAttrs> baseAttrs = spuSaveVo.getBaseAttrs();
        List<ProductAttrValue> collect = baseAttrs.stream().map(attr -> {
            ProductAttrValue valueEntity = new ProductAttrValue();
            valueEntity.setAttrId(attr.getAttrId());
            Attr id = attrService.getById(attr.getAttrId());
            valueEntity.setAttrName(id.getAttrName());
            valueEntity.setAttrValue(attr.getAttrValues());
            valueEntity.setQuickShow(attr.getShowDesc());
            valueEntity.setSpuId(spuInfo.getId());

            return valueEntity;
        }).collect(Collectors.toList());
        productAttrValueService.saveBatch(collect);
        //TODO
        Bounds bounds = spuSaveVo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds, spuBoundTo);
        spuBoundTo.setSpuId(spuInfo.getId());

        ResponseEntity responseEntity = couponFeignClient.saveSpuBounds(spuBoundTo);
        if (responseEntity.getCode() != 0) {
            log.error("远程保存sku优惠信息失败");
        }
        return ResponseEntity.ok();
    }

    private void saveSkuInfo(SpuSaveVo spuSaveVo, SpuInfo spuInfo) {
        spuSaveVo.getSkus().forEach(item -> {
            SkuInfo skuInfo = new SkuInfo();
            BeanUtils.copyProperties(item, skuInfo);
            skuInfo.setBrandId(spuInfo.getBrandId());
            skuInfo.setCatalogId(spuInfo.getCatalogId());
            skuInfo.setSaleCount(0L);
            skuInfo.setSpuId(spuInfo.getId());
            List<Images> defaultImg = item.getImages().stream().filter(images ->
                    images.getDefaultImg() == 1).collect(Collectors.toList());

            if (!ObjectUtils.isEmpty(defaultImg)) {
                skuInfo.setSkuDefaultImg(defaultImg.get(0).getImgUrl());
            }
            skuInfoService.save(skuInfo);

            List<Images> images = item.getImages();
            List<SkuImages> skuImagesList = images.stream().map(image -> {
                SkuImages skuImages = new SkuImages();
                skuImages.setImgUrl(image.getImgUrl());
                skuImages.setDefaultImg(image.getDefaultImg());
                skuImages.setSkuId(spuInfo.getId());
                skuImages.setSkuId(skuInfo.getSkuId());
                return skuImages;
            }).collect(Collectors.toList());
            skuImagesService.saveBatch(skuImagesList);

            //sku的优惠、满减等信息
            SkuReductionTo skuReductionTo = new SkuReductionTo();
            BeanUtils.copyProperties(item, skuReductionTo);
            skuReductionTo.setSkuId(skuInfo.getSkuId());
            ResponseEntity responseEntity = couponFeignClient.saveSkuReduction(skuReductionTo);
            if (responseEntity.getCode() != 0) {
                log.error("远程保存spu积分信息失败");
            }
            List<SkuSaleAttrValue> attrValueList = item.getAttr().stream().map(attr -> {
                SkuSaleAttrValue attrValue = new SkuSaleAttrValue();
                BeanUtils.copyProperties(attr, attrValue);
                attrValue.setSkuId(skuInfo.getSkuId());
                return attrValue;
            }).collect(Collectors.toList());
            skuSaleAttrValueService.saveBatch(attrValueList);
        });
    }
}




