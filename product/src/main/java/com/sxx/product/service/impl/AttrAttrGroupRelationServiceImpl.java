package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.AttrAttrgroupRelation;
import com.sxx.product.service.AttrAttrGroupRelationService;
import com.sxx.product.mapper.AttrAttrgroupRelationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenxianxin
 * 针对表【pms_attr_attrgroup_relation(属性&属性分组关联)】的数据库操作Service实现
 * @since 2021-12-02 18:42:19
 */
@Service
@RequiredArgsConstructor
public class AttrAttrGroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationMapper, AttrAttrgroupRelation>
        implements AttrAttrGroupRelationService {

    @Override
    public boolean relationDelete(List<AttrAttrgroupRelation> relation) {
        Long attrGroupId = relation.get(0).getAttrGroupId();
        List<Long> attrIds = relation.stream().map(AttrAttrgroupRelation::getAttrId).collect(Collectors.toList());
        int count  = baseMapper.deleteByAttrGroupIdAndAttrIdIn(attrGroupId,attrIds);
        return count > 0;
    }
}




