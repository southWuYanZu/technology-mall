package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.SeckillSession;
import com.sxx.coupon.service.SeckillSessionService;
import com.sxx.coupon.mapper.SeckillSessionMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_seckill_session(秒杀活动场次)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
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




