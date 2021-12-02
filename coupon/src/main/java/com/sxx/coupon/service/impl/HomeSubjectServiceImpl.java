package com.sxx.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.coupon.entity.HomeSubject;
import com.sxx.coupon.service.HomeSubjectService;
import com.sxx.coupon.mapper.HomeSubjectMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
* @description 针对表【sms_home_subject(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)】的数据库操作Service实现
* @createDate 2021-12-02 18:49:16
*/
@Service
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectMapper, HomeSubject>
    implements HomeSubjectService{

}




