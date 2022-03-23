package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.Coupon;
import com.sxx.coupon.service.CouponService;
import com.sxx.coupon.mapper.CouponMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_coupon(优惠券信息)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:51
 */
@Service
@RequiredArgsConstructor
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon>
        implements CouponService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<Coupon> query = new Query<>();
        QueryWrapper<Coupon> wrapper = new QueryWrapper<>();
        IPage<Coupon> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




