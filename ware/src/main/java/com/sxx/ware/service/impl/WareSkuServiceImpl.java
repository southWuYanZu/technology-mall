package com.sxx.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareSku;
import com.sxx.ware.mapper.WareSkuMapper;
import com.sxx.ware.service.WareSkuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_ware_sku(商品库存)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
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




