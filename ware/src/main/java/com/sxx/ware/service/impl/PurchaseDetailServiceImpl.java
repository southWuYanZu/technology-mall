package com.sxx.ware.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.constant.Cons;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.PurchaseDetail;
import com.sxx.ware.mapper.PurchaseDetailMapper;
import com.sxx.ware.service.PurchaseDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_purchase_detail】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
@Service
@RequiredArgsConstructor
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail>
        implements PurchaseDetailService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<PurchaseDetail> query = new Query<>();
        QueryWrapper<PurchaseDetail> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.and(condition -> wrapper.eq("purchase_id",key).or().eq("sku_id",key));
        }

        String status = (String) params.get("status");
        if (!StringUtils.isEmpty(status) && !Cons.STR_ZERO.equalsIgnoreCase(status)) {
            wrapper.eq("status",status);
        }

        String wareId = (String) params.get("wareId");
        if (!StringUtils.isEmpty(wareId) && !Cons.STR_ZERO.equalsIgnoreCase(wareId)) {
            wrapper.eq("ware_id",wareId);
        }

        IPage<PurchaseDetail> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




