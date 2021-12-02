package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.Category;
import com.sxx.product.service.CategoryService;
import com.sxx.product.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
* @description 针对表【pms_category(商品三级分类)】的数据库操作Service实现
* @createDate 2021-12-02 18:42:19
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




