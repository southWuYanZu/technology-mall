package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.HomeAdv;
import com.sxx.coupon.mapper.HomeAdvMapper;
import com.sxx.coupon.service.HomeAdvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_home_adv(首页轮播广告)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@Service
@RequiredArgsConstructor
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvMapper, HomeAdv>
        implements HomeAdvService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<HomeAdv> query = new Query<>();
        QueryWrapper<HomeAdv> wrapper = new QueryWrapper<>();
        IPage<HomeAdv> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




