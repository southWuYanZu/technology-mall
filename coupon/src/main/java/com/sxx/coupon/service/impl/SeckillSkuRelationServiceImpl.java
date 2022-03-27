package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SeckillSkuRelation;
import com.sxx.coupon.mapper.SeckillSkuRelationMapper;
import com.sxx.coupon.service.SeckillSkuRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_seckill_sku_relation(秒杀活动商品关联)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
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




