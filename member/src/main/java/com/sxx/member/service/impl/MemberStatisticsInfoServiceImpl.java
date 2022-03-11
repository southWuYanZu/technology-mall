package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberStatisticsInfo;
import com.sxx.member.mapper.MemberStatisticsInfoMapper;
import com.sxx.member.service.MemberStatisticsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_member_statistics_info(会员统计信息)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoMapper, MemberStatisticsInfo>
        implements MemberStatisticsInfoService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<MemberStatisticsInfo> query = new Query<>();
        QueryWrapper<MemberStatisticsInfo> wrapper = new QueryWrapper<>();
        IPage<MemberStatisticsInfo> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




