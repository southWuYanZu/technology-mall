package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberLoginLog;
import com.sxx.member.mapper.MemberLoginLogMapper;
import com.sxx.member.service.MemberLoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_member_login_log(会员登录记录)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog>
        implements MemberLoginLogService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<MemberLoginLog> query = new Query<>();
        QueryWrapper<MemberLoginLog> wrapper = new QueryWrapper<>();
        IPage<MemberLoginLog> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




