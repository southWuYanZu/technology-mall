package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.PurchaseDetail;
import com.sxx.ware.service.PurchaseDetailService;
import com.sxx.ware.mapper.PurchaseDetailMapper;
import org.springframework.stereotype.Service;

/**
* 针对表【wms_purchase_detail】的数据库操作Service实现
*
* @author Mr.shen
* @since 2022-03-10 21:53:27
*/
@Service
@RequiredArgsConstructor
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail>
implements PurchaseDetailService{

}




