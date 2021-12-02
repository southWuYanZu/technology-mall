package com.sxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.order.entity.OrderSetting;
import com.sxx.order.service.OrderSettingService;
import com.sxx.order.mapper.OrderSettingMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
* @description 针对表【oms_order_setting(订单配置信息)】的数据库操作Service实现
* @createDate 2021-12-02 18:48:47
*/
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting>
    implements OrderSettingService{

}




