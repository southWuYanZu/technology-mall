package com.sxx.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareOrderTask;
import com.sxx.ware.mapper.WareOrderTaskMapper;
import com.sxx.ware.service.WareOrderTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_ware_order_task(库存工作单)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@Service
@RequiredArgsConstructor
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskMapper, WareOrderTask>
        implements WareOrderTaskService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<WareOrderTask> query = new Query<>();
        QueryWrapper<WareOrderTask> wrapper = new QueryWrapper<>();
        IPage<WareOrderTask> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




