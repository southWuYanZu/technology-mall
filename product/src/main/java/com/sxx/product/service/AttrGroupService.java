package com.sxx.product.service;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.AttrGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 针对表【pms_attr_group(属性分组)】的数据库操作Service
 *
 * @author shenxianxin
 * @since 2021-12-02 18:42:19
 */
public interface AttrGroupService extends IService<AttrGroup> {

    /**
     * 获取属性分组列表
     *
     * @param params 属性分组参数 包含当前页,分页条数...
     * @param catId  三级分类ID 区别查询列表全部还是 ID 信息
     * @return 数据集
     */
    ResponseEntity queryPage(Map<String, Object> params, Long catId);
}
