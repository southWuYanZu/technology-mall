package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SeckillSkuNotice;
import com.sxx.coupon.mapper.SeckillSkuNoticeMapper;
import com.sxx.coupon.service.SeckillSkuNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_seckill_sku_notice(秒杀商品通知订阅)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@Service
@RequiredArgsConstructor
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeMapper, SeckillSkuNotice>
        implements SeckillSkuNoticeService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SeckillSkuNotice> query = new Query<>();
        QueryWrapper<SeckillSkuNotice> wrapper = new QueryWrapper<>();
        IPage<SeckillSkuNotice> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




