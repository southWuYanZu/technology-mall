package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SeckillSession;
import com.sxx.coupon.mapper.SeckillSessionMapper;
import com.sxx.coupon.service.SeckillSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_seckill_session(秒杀活动场次)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@Service
@RequiredArgsConstructor
public class SeckillSessionServiceImpl extends ServiceImpl<SeckillSessionMapper, SeckillSession>
        implements SeckillSessionService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SeckillSession> query = new Query<>();
        QueryWrapper<SeckillSession> wrapper = new QueryWrapper<>();
        IPage<SeckillSession> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




