package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.WareOrderTaskDetail;
import com.sxx.ware.service.WareOrderTaskDetailService;
import com.sxx.ware.mapper.WareOrderTaskDetailMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_ware_order_task_detail(库存工作单)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@Service
@RequiredArgsConstructor
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailMapper, WareOrderTaskDetail>
        implements WareOrderTaskDetailService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<WareOrderTaskDetail> query = new Query<>();
        QueryWrapper<WareOrderTaskDetail> wrapper = new QueryWrapper<>();
        IPage<WareOrderTaskDetail> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




