package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SpuBounds;
import com.sxx.coupon.mapper.SpuBoundsMapper;
import com.sxx.coupon.service.SpuBoundsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_spu_bounds(商品spu积分设置)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@Service
@RequiredArgsConstructor
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsMapper, SpuBounds>
        implements SpuBoundsService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SpuBounds> query = new Query<>();
        QueryWrapper<SpuBounds> wrapper = new QueryWrapper<>();
        IPage<SpuBounds> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




