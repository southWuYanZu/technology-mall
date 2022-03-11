package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberLevel;
import com.sxx.member.enums.MemberConstantAndEnum;
import com.sxx.member.service.MemberLevelService;
import com.sxx.member.mapper.MemberLevelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author shenxianxin
 * 针对表【ums_member_level(会员等级)】的数据库操作Service实现
 * @since 2021-12-02 18:31:53
 */
@Service
@RequiredArgsConstructor
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel>
        implements MemberLevelService {

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<MemberLevel> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            wrapper.eq(MemberConstantAndEnum.COLUMN_ID, key).or().likeRight(MemberConstantAndEnum.COLUMN_NAME, key);
        }
        IPage<MemberLevel> page = this.page(new Query<MemberLevel>().getPage(params), wrapper);
        return ResponseEntity.ok("page", new PageUtils(page));
    }
}




