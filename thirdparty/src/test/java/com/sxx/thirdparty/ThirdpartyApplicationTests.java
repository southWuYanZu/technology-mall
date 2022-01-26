package com.sxx.thirdparty;

import com.aliyun.oss.OSS;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@RequiredArgsConstructor
class ThirdpartyApplicationTests {

    private final OSS oss;

    @Test
    void contextLoads() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("E:\\aa.jpg");

        oss.putObject("tech-mall","tech-mall",inputStream);
    }

}
