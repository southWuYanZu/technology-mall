package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberLevel;
import com.sxx.member.mapper.MemberLevelMapper;
import com.sxx.member.service.MemberLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_member_level(会员等级)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel>
        implements MemberLevelService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<MemberLevel> query = new Query<>();
        QueryWrapper<MemberLevel> wrapper = new QueryWrapper<>();
        IPage<MemberLevel> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




