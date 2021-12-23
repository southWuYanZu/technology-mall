package com.sxx.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.WareSku;
import com.sxx.ware.service.WareSkuService;
import com.sxx.ware.mapper.WareSkuMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【wms_ware_sku(商品库存)】的数据库操作Service实现
* @since 2021-12-02 18:50:01
*/
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku>
    implements WareSkuService{

}




