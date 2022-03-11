package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.IntegrationChangeHistory;
import com.sxx.member.mapper.IntegrationChangeHistoryMapper;
import com.sxx.member.service.IntegrationChangeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_integration_change_history(积分变化历史记录)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryMapper, IntegrationChangeHistory>
        implements IntegrationChangeHistoryService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<IntegrationChangeHistory> query = new Query<>();
        QueryWrapper<IntegrationChangeHistory> wrapper = new QueryWrapper<>();
        IPage<IntegrationChangeHistory> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




