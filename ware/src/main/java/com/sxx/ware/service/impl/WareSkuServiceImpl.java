package com.sxx.ware.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.constant.Cons;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareSku;
import com.sxx.ware.feign.ProductFeignClient;
import com.sxx.ware.mapper.WareSkuMapper;
import com.sxx.ware.service.WareSkuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 针对表【wms_ware_sku(商品库存)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
@Service
@RequiredArgsConstructor
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku>
        implements WareSkuService {

    private final ProductFeignClient productFeignClient;

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<WareSku> query = new Query<>();
        QueryWrapper<WareSku> wrapper = new QueryWrapper<>();
        String skuId = (String) params.get("skuId");
        if (!StringUtils.isEmpty(skuId) && !Cons.STR_ZERO.equalsIgnoreCase(skuId)) {
            wrapper.eq("sku_id", skuId);
        }

        String wareId = (String) params.get("wareId");
        if (!StringUtils.isEmpty(wareId) && !Cons.STR_ZERO.equalsIgnoreCase(wareId)) {
            wrapper.eq("ware_id", wareId);
        }

        IPage<WareSku> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page", new PageUtils(page));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {

        int row = baseMapper.updateStockBySkuIdAndWareId(skuNum, skuId, wareId);

        if (row < 1) {
            WareSku wareSku = new WareSku();
            wareSku.setSkuId(skuId);
            try {
                ResponseEntity responseEntity = productFeignClient.info(skuId);
                if (responseEntity.getCode() == 0) {
                      Map<String, Object> skuInfo;
                    skuInfo = (Map<String, Object>) responseEntity.get("skuInfo");
                    String skuName = (String) skuInfo.get("skuName");
                    wareSku.setSkuName(skuName);
                }
            } catch (Exception e) {
                return;
            }
            wareSku.setStock(skuNum);
            wareSku.setWareId(wareId);
            this.baseMapper.insert(wareSku);
        }

    }
}




