package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.SeckillSkuRelation;
import com.sxx.coupon.service.SeckillSkuRelationService;
import com.sxx.coupon.mapper.SeckillSkuRelationMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_seckill_sku_relation(秒杀活动商品关联)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@Service
@RequiredArgsConstructor
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationMapper, SeckillSkuRelation>
        implements SeckillSkuRelationService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SeckillSkuRelation> query = new Query<>();
        QueryWrapper<SeckillSkuRelation> wrapper = new QueryWrapper<>();
        IPage<SeckillSkuRelation> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




