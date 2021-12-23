package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.member.entity.Member;
import com.sxx.member.service.MemberService;
import com.sxx.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【ums_member(会员)】的数据库操作Service实现
* @since 2021-12-02 18:31:53
*/
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
    implements MemberService{

}




