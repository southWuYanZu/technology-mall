package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.Purchase;
import com.sxx.ware.service.PurchaseService;
import com.sxx.ware.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_purchase(采购信息)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase>
        implements PurchaseService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<Purchase> query = new Query<>();
        QueryWrapper<Purchase> wrapper = new QueryWrapper<>();
        IPage<Purchase> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




