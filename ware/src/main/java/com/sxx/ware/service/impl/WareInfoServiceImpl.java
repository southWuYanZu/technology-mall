package com.sxx.ware.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareInfo;
import com.sxx.ware.mapper.WareInfoMapper;
import com.sxx.ware.service.WareInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_ware_info(仓库信息)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
@Service
@RequiredArgsConstructor
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo>
        implements WareInfoService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<WareInfo> query = new Query<>();
        QueryWrapper<WareInfo> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.eq("id",key)
                    .or().like("name",key)
                    .or().like("address",key)
                    .or().like("areacode",key);
        }

        IPage<WareInfo> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




