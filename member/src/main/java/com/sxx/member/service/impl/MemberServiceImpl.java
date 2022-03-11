package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.Member;
import com.sxx.member.enums.MemberConstantAndEnum;
import com.sxx.member.service.MemberService;
import com.sxx.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author shenxianxin
 * 针对表【ums_member(会员)】的数据库操作Service实现
 * @since 2021-12-02 18:31:53
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
        implements MemberService {

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<Member> wrapper = null;
        if (!StringUtils.isEmpty(key)) {
            wrapper = new QueryWrapper<>();
            wrapper.eq(MemberConstantAndEnum.COLUMN_ID, key).or().like(MemberConstantAndEnum.COLUMN_USERNAME, key).or()
                    .likeRight(MemberConstantAndEnum.COLUMN_NICKNAME, key);
        }
        IPage<Member> page = this.page(new Query<Member>().getPage(params), wrapper);
        return ResponseEntity.ok("page", new PageUtils(page));
    }
}




