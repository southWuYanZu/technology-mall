package com.sxx.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.constant.Cons;
import com.sxx.common.constant.ProductConstant;
import com.sxx.common.es.SkuEsModel;
import com.sxx.common.to.SkuHasStockVo;
import com.sxx.common.to.SkuReductionTo;
import com.sxx.common.to.SpuBoundTo;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.*;
import com.sxx.product.enums.ProConsEnums;
import com.sxx.product.feign.CouponFeignClient;
import com.sxx.product.feign.SearchFeignClient;
import com.sxx.product.feign.WareFeignClient;
import com.sxx.product.mapper.SpuInfoMapper;
import com.sxx.product.service.*;
import com.sxx.product.vo.BaseAttrs;
import com.sxx.product.vo.Bounds;
import com.sxx.product.vo.Images;
import com.sxx.product.vo.SpuSaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;
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

    private final BrandService brandService;

    private final SpuInfoDescService descService;

    private final SkuInfoService skuInfoService;

    private final CategoryService categoryService;

    private final WareFeignClient wareFeignClient;

    private final SpuImagesService spuImagesService;

    private final SkuImagesService skuImagesService;

    private final CouponFeignClient couponFeignClient;

    private final SearchFeignClient searchFeignClient;

    private final SkuSaleAttrValueService skuSaleAttrValueService;

    private final ProductAttrValueService productAttrValueService;

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SpuInfo> query = new Query<>();
        QueryWrapper<SpuInfo> wrapper = new QueryWrapper<>();

        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.and(condition -> condition.eq(ProConsEnums.COLUMN_ID, key).or().like(ProConsEnums.COLUMN_SPU_NAME, key));
        }

        String status = (String) params.get("status");
        if (!StringUtils.isEmpty(status)) {
            wrapper.eq(ProConsEnums.COLUMN_STATUS, status);
        }
        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId) && !Cons.STR_ZERO.equalsIgnoreCase(brandId)) {
            wrapper.eq(ProConsEnums.COLUMN_BRAND_ID, brandId);
        }

        String catelogId = (String) params.get("catelogId");
        if (!StringUtils.isEmpty(catelogId) && !Cons.STR_ZERO.equalsIgnoreCase(catelogId)) {
            wrapper.eq(ProConsEnums.COLUMN_CATELOG_ID, catelogId);
        }
        IPage<SpuInfo> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page", new PageUtils(page));
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
        saveSkuInfo(spuSaveVo, spuInfo);

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void up(Long spuId) {

        //1、查出当前spuId对应的所有sku信息,品牌的名字
        List<SkuInfo> skuInfoEntities = skuInfoService.getSkusBySpuId(spuId);

        //TODO 4、查出当前sku的所有可以被用来检索的规格属性
        List<ProductAttrValue> baseAttrs = productAttrValueService.baseAttrListForSpu(spuId);

        List<Long> attrIds = baseAttrs.stream().map(ProductAttrValue::getAttrId).collect(Collectors.toList());

        List<Long> searchAttrIds = attrService.selectSearchAttrs(attrIds);
        //转换为Set集合
        Set<Long> idSet = new HashSet<>(searchAttrIds);

        List<SkuEsModel.Attrs> attrsList = baseAttrs.stream().filter(item ->
                idSet.contains(item.getAttrId())).map(item -> {
            SkuEsModel.Attrs attrs = new SkuEsModel.Attrs();
            BeanUtils.copyProperties(item, attrs);
            return attrs;
        }).collect(Collectors.toList());

        List<Long> skuIdList = skuInfoEntities.stream()
                .map(SkuInfo::getSkuId)
                .collect(Collectors.toList());

        //TODO 1、发送远程调用，库存系统查询是否有库存
        Map<Long, Boolean> stockMap = null;
        try {
            ResponseEntity skuHasStock = wareFeignClient.getSkuHasStock(skuIdList);
            TypeReference<List<SkuHasStockVo>> typeReference = new TypeReference<List<SkuHasStockVo>>() {
            };
            stockMap = skuHasStock.getData(typeReference).stream()
                    .collect(Collectors.toMap(SkuHasStockVo::getSkuId, SkuHasStockVo::getHasStock));
        } catch (Exception e) {
            log.error("库存服务查询异常：原因{}", e);
        }

        //2、封装每个sku的信息
        Map<Long, Boolean> finalStockMap = stockMap;
        List<SkuEsModel> collect = skuInfoEntities.stream().map(sku -> {
            //组装需要的数据
            SkuEsModel esModel = new SkuEsModel();
            esModel.setSkuPrice(sku.getPrice());
            esModel.setSkuImg(sku.getSkuDefaultImg());

            //设置库存信息
            if (finalStockMap == null) {
                esModel.setHasStock(true);
            } else {
                esModel.setHasStock(finalStockMap.get(sku.getSkuId()));
            }

            //TODO 2、热度评分。0
            esModel.setHotScore(0L);

            //TODO 3、查询品牌和分类的名字信息
            Brand brandEntity = brandService.getById(sku.getBrandId());
            esModel.setBrandName(brandEntity.getName());
            esModel.setBrandId(brandEntity.getBrandId());
            esModel.setBrandImg(brandEntity.getLogo());

            Category categoryEntity = categoryService.getById(sku.getCatalogId());
            esModel.setCatalogId(categoryEntity.getCatId());
            esModel.setCatalogName(categoryEntity.getName());

            //设置检索属性
            esModel.setAttrs(attrsList);

            BeanUtils.copyProperties(sku, esModel);

            return esModel;
        }).collect(Collectors.toList());

        //TODO 5、将数据发给es进行保存：search
        ResponseEntity r = searchFeignClient.productStatusUp(collect);

        if (r.getCode() == 0) {
            //远程调用成功
            //TODO 6、修改当前spu的状态
            this.baseMapper.updateSpuStatus(spuId, ProductConstant.ProductStatusEnum.SPU_UP.getCode());
        } else {
            log.error("TODO");
            //远程调用失败
            //TODO 7、重复调用？接口幂等性:重试机制
        }
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




