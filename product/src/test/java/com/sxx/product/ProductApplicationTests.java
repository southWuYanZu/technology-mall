package com.sxx.product;

import com.sxx.product.entity.Brand;
import com.sxx.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        Brand brand = new Brand();
        brand.setName("huawei");
        brandService.save(brand);
    }


}
