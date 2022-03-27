package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.CouponHistory;
import com.sxx.coupon.mapper.CouponHistoryMapper;
import com.sxx.coupon.service.CouponHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_coupon_history(优惠券领取历史记录)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@Service
@RequiredArgsConstructor
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistory>
        implements CouponHistoryService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<CouponHistory> query = new Query<>();
        QueryWrapper<CouponHistory> wrapper = new QueryWrapper<>();
        IPage<CouponHistory> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




