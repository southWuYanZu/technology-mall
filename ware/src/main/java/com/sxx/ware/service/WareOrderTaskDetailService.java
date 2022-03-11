package com.sxx.ware.service;

import com.sxx.ware.entity.WareOrderTaskDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* 针对表【wms_ware_order_task_detail(库存工作单)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-11 16:05:17
*/
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetail> {

    /**
     * 查询wms_ware_order_task_detail(库存工作单)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
