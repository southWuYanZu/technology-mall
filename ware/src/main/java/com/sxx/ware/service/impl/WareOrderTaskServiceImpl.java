package com.sxx.ware.service.impl;

import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.ware.entity.WareOrderTask;
import com.sxx.ware.service.WareOrderTaskService;
import com.sxx.ware.mapper.WareOrderTaskMapper;
import org.springframework.stereotype.Service;

/**
* 针对表【wms_ware_order_task(库存工作单)】的数据库操作Service实现
*
* @author Mr.shen
* @since 2022-03-10 21:53:27
*/
@Service
@RequiredArgsConstructor
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskMapper, WareOrderTask>
implements WareOrderTaskService{

}




