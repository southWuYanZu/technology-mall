package com.sxx.product;

import com.sxx.product.entity.Brand;
import com.sxx.product.service.BrandService;
import com.sxx.product.service.impl.BrandServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class ProductApplicationTests {
    private final BrandService brandService;

    @Test
    void contextLoads() {
        Brand brand = new Brand();
        brand.setName("huawei");
        brandService.save(brand);
    }

}
