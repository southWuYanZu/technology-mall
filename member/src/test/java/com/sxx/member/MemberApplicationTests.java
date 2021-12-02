package com.sxx.member;


import com.sxx.member.entity.Member;
import com.sxx.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class MemberApplicationTests {
    private final MemberService memberService;
    @Test
    void contextLoads() {
        Member member = new Member();
        member.setEmail("2733656558");
        memberService.save(member);

    }

}
