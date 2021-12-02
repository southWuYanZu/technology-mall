package com.sxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.order.entity.OrderReturnReason;
import com.sxx.order.service.OrderReturnReasonService;
import com.sxx.order.mapper.OrderReturnReasonMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
* @description 针对表【oms_order_return_reason(退货原因)】的数据库操作Service实现
* @createDate 2021-12-02 18:48:47
*/
@Service
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReason>
    implements OrderReturnReasonService{

}




