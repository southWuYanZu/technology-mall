package com.sxx.product;

import com.sxx.common.utils.EnumUtils;
import com.sxx.product.enums.ProductEnum;
import com.sxx.product.service.BrandService;
import com.sxx.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class ProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Autowired
    private CategoryService categoryService;
    @Test
    void contextLoads() throws Exception{
        Long[] categoryPathById = categoryService.findCategoryPathById(10L);
        System.out.println(Arrays.asList(categoryPathById));
    }

    @Test
    void enumTest() {
        System.out.println(EnumUtils.getCodeByValue("基本属性", ProductEnum.AttrEnum.class));
        System.out.println(EnumUtils.getValueByCode(1, ProductEnum.AttrEnum.class));
    }


}
