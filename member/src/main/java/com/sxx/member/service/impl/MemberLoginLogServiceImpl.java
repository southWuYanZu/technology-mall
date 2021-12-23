package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.member.entity.MemberLoginLog;
import com.sxx.member.service.MemberLoginLogService;
import com.sxx.member.mapper.MemberLoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【ums_member_login_log(会员登录记录)】的数据库操作Service实现
* @since 2021-12-02 18:31:53
*/
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog>
    implements MemberLoginLogService{

}




