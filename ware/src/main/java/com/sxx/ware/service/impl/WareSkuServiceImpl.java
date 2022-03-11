package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.WareSku;
import com.sxx.ware.service.WareSkuService;
import com.sxx.ware.mapper.WareSkuMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_ware_sku(商品库存)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@Service
@RequiredArgsConstructor
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku>
        implements WareSkuService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<WareSku> query = new Query<>();
        QueryWrapper<WareSku> wrapper = new QueryWrapper<>();
        IPage<WareSku> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




