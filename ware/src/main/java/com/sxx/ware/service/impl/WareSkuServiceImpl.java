package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.WareSku;
import com.sxx.ware.service.WareSkuService;
import com.sxx.ware.mapper.WareSkuMapper;
import org.springframework.stereotype.Service;

/**
* 针对表【wms_ware_sku(商品库存)】的数据库操作Service实现
*
* @author Mr.shen
* @since 2022-03-10 21:53:27
*/
@Service
@RequiredArgsConstructor
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku>
implements WareSkuService{

}




