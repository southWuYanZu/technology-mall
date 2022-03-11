package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.Purchase;
import com.sxx.ware.service.PurchaseService;
import com.sxx.ware.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

/**
* 针对表【wms_purchase(采购信息)】的数据库操作Service实现
*
* @author Mr.shen
* @since 2022-03-10 21:53:27
*/
@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase>
implements PurchaseService{

}




