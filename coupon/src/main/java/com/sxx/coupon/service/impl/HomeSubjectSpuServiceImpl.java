package com.sxx.coupon.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.HomeSubjectSpu;
import com.sxx.coupon.service.HomeSubjectSpuService;
import com.sxx.coupon.mapper.HomeSubjectSpuMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_home_subject_spu(专题商品)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@Service
@RequiredArgsConstructor
public class HomeSubjectSpuServiceImpl extends ServiceImpl<HomeSubjectSpuMapper, HomeSubjectSpu>
        implements HomeSubjectSpuService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<HomeSubjectSpu> query = new Query<>();
        QueryWrapper<HomeSubjectSpu> wrapper = new QueryWrapper<>();
        IPage<HomeSubjectSpu> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




