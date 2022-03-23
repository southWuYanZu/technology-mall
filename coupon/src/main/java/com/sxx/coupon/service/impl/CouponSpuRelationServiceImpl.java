package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.CouponSpuRelation;
import com.sxx.coupon.service.CouponSpuRelationService;
import com.sxx.coupon.mapper.CouponSpuRelationMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_coupon_spu_relation(优惠券与产品关联)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@Service
@RequiredArgsConstructor
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationMapper, CouponSpuRelation>
        implements CouponSpuRelationService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<CouponSpuRelation> query = new Query<>();
        QueryWrapper<CouponSpuRelation> wrapper = new QueryWrapper<>();
        IPage<CouponSpuRelation> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




