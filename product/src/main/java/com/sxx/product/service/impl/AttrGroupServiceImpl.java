package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.mapper.AttrGroupMapper;
import com.sxx.product.service.AttrGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 针对表【pms_attr_group(属性分组)】的数据库操作Service实现
 *
 * @author shenxianxin
 * @since 2021-12-02 18:42:19
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup>
        implements AttrGroupService {

    /**
     * 获取属性分组列表
     *
     * @param params 属性分组参数 包含当前页,分页条数...
     * @param catId  三级分类ID 区别查询列表全部还是 ID 信息
     * @return 数据集
     */
    @Override
    public ResponseEntity queryPage(Map<String, Object> params, Long catId) {

        List<AttrGroup> attrGroupList = this.list();
        return null;
    }
}




