package com.sxx.thirdparty.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.thirdparty.service.OssService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Mr.shen
 * @since 2022/01/13 下午 10:38
 */
@RestController()
@RequestMapping("/thirdparty/oss")
@RequiredArgsConstructor
public class OssController {

    private final OssService ossService;

    private final OSS oss;
    /**
     * oss云存储
     *
     * @return kid 信息
     */
    @GetMapping("/policy")
    public ResponseEntity policy() {
        return ResponseEntity.ok("data", ossService.policy());
    }

    @GetMapping("test")
    public ResponseEntity test() throws FileNotFoundException {
        PutObjectResult putObjectResult = oss.putObject("tech-mall", "tech-mall", new FileInputStream("E:\\aa.jpg"));
        return null;
    }
}
