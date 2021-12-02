package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.Brand;
import com.sxx.product.service.BrandService;
import com.sxx.product.mapper.BrandMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
* @description 针对表【pms_brand(品牌)】的数据库操作Service实现
* @createDate 2021-12-02 18:42:19
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{

}




