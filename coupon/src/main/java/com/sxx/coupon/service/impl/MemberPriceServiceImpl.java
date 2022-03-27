package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.MemberPrice;
import com.sxx.coupon.mapper.MemberPriceMapper;
import com.sxx.coupon.service.MemberPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_member_price(商品会员价格)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
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




