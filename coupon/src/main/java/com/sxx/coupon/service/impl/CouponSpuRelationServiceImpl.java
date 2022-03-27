package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.CouponSpuRelation;
import com.sxx.coupon.mapper.CouponSpuRelationMapper;
import com.sxx.coupon.service.CouponSpuRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_coupon_spu_relation(优惠券与产品关联)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
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




