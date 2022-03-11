package com.sxx.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareInfo;

import java.util.Map;

/**
* 针对表【wms_ware_info(仓库信息)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-11 16:05:17
*/
public interface WareInfoService extends IService<WareInfo> {

    /**
     * 查询wms_ware_info(仓库信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
