package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.MemberPrice;
import com.sxx.coupon.service.MemberPriceService;
import com.sxx.coupon.mapper.MemberPriceMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_member_price(商品会员价格)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@Service
@RequiredArgsConstructor
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper, MemberPrice>
        implements MemberPriceService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<MemberPrice> query = new Query<>();
        QueryWrapper<MemberPrice> wrapper = new QueryWrapper<>();
        IPage<MemberPrice> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




