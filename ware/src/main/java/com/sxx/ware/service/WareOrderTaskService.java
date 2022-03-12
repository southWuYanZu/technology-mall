package com.sxx.ware.service;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareOrderTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【wms_ware_order_task(库存工作单)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-11 16:05:17
*/
public interface WareOrderTaskService extends IService<WareOrderTask> {

    /**
     * 查询wms_ware_order_task(库存工作单)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
