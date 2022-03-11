package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberCollectSubject;
import com.sxx.member.mapper.MemberCollectSubjectMapper;
import com.sxx.member.service.MemberCollectSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_member_collect_subject(会员收藏的专题活动)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class MemberCollectSubjectServiceImpl extends ServiceImpl<MemberCollectSubjectMapper, MemberCollectSubject>
        implements MemberCollectSubjectService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<MemberCollectSubject> query = new Query<>();
        QueryWrapper<MemberCollectSubject> wrapper = new QueryWrapper<>();
        IPage<MemberCollectSubject> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




