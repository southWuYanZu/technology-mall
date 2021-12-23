package com.sxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.order.entity.Order;
import com.sxx.order.service.OrderService;
import com.sxx.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【oms_order(订单)】的数据库操作Service实现
* @since 2021-12-02 18:48:47
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




