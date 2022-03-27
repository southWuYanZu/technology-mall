package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.HomeSubject;
import com.sxx.coupon.mapper.HomeSubjectMapper;
import com.sxx.coupon.service.HomeSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【sms_home_subject(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@Service
@RequiredArgsConstructor
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectMapper, HomeSubject>
        implements HomeSubjectService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<HomeSubject> query = new Query<>();
        QueryWrapper<HomeSubject> wrapper = new QueryWrapper<>();
        IPage<HomeSubject> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




