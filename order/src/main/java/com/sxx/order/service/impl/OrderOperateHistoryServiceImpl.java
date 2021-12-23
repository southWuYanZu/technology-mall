package com.sxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.order.entity.OrderOperateHistory;
import com.sxx.order.service.OrderOperateHistoryService;
import com.sxx.order.mapper.OrderOperateHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【oms_order_operate_history(订单操作历史记录)】的数据库操作Service实现
* @since 2021-12-02 18:48:47
*/
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory>
    implements OrderOperateHistoryService{

}




