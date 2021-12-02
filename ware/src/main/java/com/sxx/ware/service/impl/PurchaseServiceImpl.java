package com.sxx.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.Purchase;
import com.sxx.ware.service.PurchaseService;
import com.sxx.ware.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
* @description 针对表【wms_purchase(采购信息)】的数据库操作Service实现
* @createDate 2021-12-02 18:50:01
*/
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase>
    implements PurchaseService{

}




