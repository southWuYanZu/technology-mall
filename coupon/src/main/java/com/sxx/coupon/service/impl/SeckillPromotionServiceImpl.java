package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.SeckillPromotion;
import com.sxx.coupon.service.SeckillPromotionService;
import com.sxx.coupon.mapper.SeckillPromotionMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_seckill_promotion(秒杀活动)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
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




