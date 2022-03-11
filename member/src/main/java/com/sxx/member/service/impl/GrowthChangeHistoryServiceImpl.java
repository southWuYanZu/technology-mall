package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.GrowthChangeHistory;
import com.sxx.member.mapper.GrowthChangeHistoryMapper;
import com.sxx.member.service.GrowthChangeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_growth_change_history(成长值变化历史记录)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryMapper, GrowthChangeHistory>
        implements GrowthChangeHistoryService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<GrowthChangeHistory> query = new Query<>();
        QueryWrapper<GrowthChangeHistory> wrapper = new QueryWrapper<>();
        IPage<GrowthChangeHistory> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




