package com.sxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.order.entity.PaymentInfo;
import com.sxx.order.service.PaymentInfoService;
import com.sxx.order.mapper.PaymentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
* @description 针对表【oms_payment_info(支付信息表)】的数据库操作Service实现
* @createDate 2021-12-02 18:48:47
*/
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo>
    implements PaymentInfoService{

}




