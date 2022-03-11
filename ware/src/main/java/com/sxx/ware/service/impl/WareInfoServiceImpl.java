package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.WareInfo;
import com.sxx.ware.service.WareInfoService;
import com.sxx.ware.mapper.WareInfoMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【wms_ware_info(仓库信息)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@Service
@RequiredArgsConstructor
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo>
        implements WareInfoService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<WareInfo> query = new Query<>();
        QueryWrapper<WareInfo> wrapper = new QueryWrapper<>();
        IPage<WareInfo> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




