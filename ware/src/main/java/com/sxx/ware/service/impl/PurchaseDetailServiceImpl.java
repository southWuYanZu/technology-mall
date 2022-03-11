package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.PurchaseDetail;
import com.sxx.ware.service.PurchaseDetailService;
import com.sxx.ware.mapper.PurchaseDetailMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_purchase_detail】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@Service
@RequiredArgsConstructor
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail>
        implements PurchaseDetailService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<PurchaseDetail> query = new Query<>();
        QueryWrapper<PurchaseDetail> wrapper = new QueryWrapper<>();
        IPage<PurchaseDetail> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




