package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.HomeSubjectSpu;
import com.sxx.coupon.mapper.HomeSubjectSpuMapper;
import com.sxx.coupon.service.HomeSubjectSpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_home_subject_spu(专题商品)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
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




