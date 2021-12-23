package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.SpuInfo;
import com.sxx.product.service.SpuInfoService;
import com.sxx.product.mapper.SpuInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【pms_spu_info(spu信息)】的数据库操作Service实现
* @since 2021-12-02 18:42:19
*/
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo>
    implements SpuInfoService{

}




