package com.sxx.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.WareInfo;
import com.sxx.ware.service.WareInfoService;
import com.sxx.ware.mapper.WareInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【wms_ware_info(仓库信息)】的数据库操作Service实现
* @since 2021-12-02 18:50:01
*/
@Service
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo>
    implements WareInfoService{

}




