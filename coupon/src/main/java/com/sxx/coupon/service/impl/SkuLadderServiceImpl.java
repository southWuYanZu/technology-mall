package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.SkuLadder;
import com.sxx.coupon.service.SkuLadderService;
import com.sxx.coupon.mapper.SkuLadderMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_sku_ladder(商品阶梯价格)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@Service
@RequiredArgsConstructor
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderMapper, SkuLadder>
        implements SkuLadderService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<SkuLadder> query = new Query<>();
        QueryWrapper<SkuLadder> wrapper = new QueryWrapper<>();
        IPage<SkuLadder> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




