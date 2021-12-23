package com.sxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.order.entity.OrderItem;
import com.sxx.order.service.OrderItemService;
import com.sxx.order.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【oms_order_item(订单项信息)】的数据库操作Service实现
* @since 2021-12-02 18:48:47
*/
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem>
    implements OrderItemService{

}




