package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.to.SkuReductionTo;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.MemberPrice;
import com.sxx.coupon.entity.SkuFullReduction;
import com.sxx.coupon.entity.SkuLadder;
import com.sxx.coupon.mapper.SkuFullReductionMapper;
import com.sxx.coupon.service.SkuFullReductionService;
import com.sxx.coupon.service.SkuLadderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 针对表【sms_sku_full_reduction(商品满减信息)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@Service
@RequiredArgsConstructor
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReduction>
        implements SkuFullReductionService{

    private final SkuLadderService skuLadderService;

    private final MemberPriceServiceImpl memberPriceService;
    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SkuFullReduction> query = new Query<>();
        QueryWrapper<SkuFullReduction> wrapper = new QueryWrapper<>();
        IPage<SkuFullReduction> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }

    @Override
    public void saveSkuReduction(SkuReductionTo skuReductionTo) {
        //1、sku的优惠、满减等信息
        //sms_sku_ladder
        SkuLadder skuLadderEntity = new SkuLadder();
        skuLadderEntity.setSkuId(skuReductionTo.getSkuId());
        skuLadderEntity.setFullCount(skuReductionTo.getFullCount());
        skuLadderEntity.setDiscount(skuReductionTo.getDiscount());
        skuLadderEntity.setAddOther(skuReductionTo.getCountStatus());
        if(skuReductionTo.getFullCount() > 0){
            skuLadderService.save(skuLadderEntity);
        }

        //2、sms_sku_full_reduction
        SkuFullReduction reductionEntity = new SkuFullReduction();
        BeanUtils.copyProperties(skuReductionTo,reductionEntity);
        if(reductionEntity.getFullPrice().compareTo(BigDecimal.ZERO) > 0){
            this.save(reductionEntity);
        }

        //3、sms_member_price
        List<com.sxx.common.to.MemberPrice> memberPrice = skuReductionTo.getMemberPrice();
        List<MemberPrice> collect = memberPrice.stream().map(item -> {
            MemberPrice priceEntity = new MemberPrice();
            priceEntity.setSkuId(skuReductionTo.getSkuId());
            priceEntity.setMemberLevelId(item.getId());
            priceEntity.setMemberLevelName(item.getName());
            priceEntity.setMemberPrice(item.getPrice());
            priceEntity.setAddOther(1);
            return priceEntity;
        }).filter(item-> (item.getMemberPrice().compareTo(BigDecimal.ZERO)) > 0
        ).collect(Collectors.toList());
        memberPriceService.saveBatch(collect);
    }
}




