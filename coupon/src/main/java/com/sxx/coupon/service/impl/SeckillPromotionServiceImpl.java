package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SeckillPromotion;
import com.sxx.coupon.mapper.SeckillPromotionMapper;
import com.sxx.coupon.service.SeckillPromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_seckill_promotion(秒杀活动)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@Service
@RequiredArgsConstructor
public class SeckillPromotionServiceImpl extends ServiceImpl<SeckillPromotionMapper, SeckillPromotion>
        implements SeckillPromotionService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SeckillPromotion> query = new Query<>();
        QueryWrapper<SeckillPromotion> wrapper = new QueryWrapper<>();
        IPage<SeckillPromotion> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




