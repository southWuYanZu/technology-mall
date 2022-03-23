package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.CouponSpuCategoryRelation;
import com.sxx.coupon.service.CouponSpuCategoryRelationService;
import com.sxx.coupon.mapper.CouponSpuCategoryRelationMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_coupon_spu_category_relation(优惠券分类关联)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@Service
@RequiredArgsConstructor
public class CouponSpuCategoryRelationServiceImpl extends ServiceImpl<CouponSpuCategoryRelationMapper, CouponSpuCategoryRelation>
        implements CouponSpuCategoryRelationService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<CouponSpuCategoryRelation> query = new Query<>();
        QueryWrapper<CouponSpuCategoryRelation> wrapper = new QueryWrapper<>();
        IPage<CouponSpuCategoryRelation> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




