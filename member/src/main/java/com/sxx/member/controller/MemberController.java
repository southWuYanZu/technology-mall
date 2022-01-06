package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @GetMapping("memberList")
    public ResponseEntity memberList() {
        return ResponseEntity.ok().put("member", "hello feign");
    }
}
