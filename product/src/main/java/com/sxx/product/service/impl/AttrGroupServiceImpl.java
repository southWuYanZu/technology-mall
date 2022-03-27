package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.sxx.common.exception.SqlException;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.Attr;
import com.sxx.product.entity.AttrAttrgroupRelation;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.enums.ProConsEnums;
import com.sxx.product.mapper.AttrGroupMapper;
import com.sxx.product.service.AttrGroupService;
import com.sxx.product.service.AttrService;
import com.sxx.product.vo.AttrGroupFindAttrVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 针对表【pms_attr_group(属性分组)】的数据库操作Service实现
 *
 * @author shenxianxin
 * @since 2021-12-02 18:42:19
 */
@Service
@RequiredArgsConstructor
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup>
        implements AttrGroupService {

    private final AttrAttrGroupRelationServiceImpl relationService;

    private final AttrService attrService;

    /**
     * 获取属性分组列表
     *
     * @param params 属性分组参数 包含当前页,分页条数...
     * @param catId  三级分类ID 区别查询列表全部还是 ID 信息
     * @return 数据集
     */
    @Override
    public ResponseEntity queryPage(Map<String, Object> params, Long catId) {
        String key = (String) params.get("key");
        QueryWrapper<AttrGroup> wrapper = new QueryWrapper<>();
        if (catId != 0) {
            wrapper.eq(ProConsEnums.COLUMN_CATELOG_ID, catId);
        }
        if (!StringUtils.isNullOrEmpty(key)) {
            wrapper.and(condition -> condition.eq(ProConsEnums.COLUMN_ATTR_GROUP_NAME, key).or().likeRight("descript", key));
        }
        IPage<AttrGroup> page = this.page(new Query<AttrGroup>().getPage(params), wrapper);
        return ResponseEntity.ok("page", new PageUtils(page));
    }

    @Override
    public ResponseEntity attrRelationShip(Long attrgroupId) {
        if (attrgroupId == null) {
            return ResponseEntity.error("商品信息加载失败,商品分组信息不能为空");
        }
        List<AttrAttrgroupRelation> relations = relationService.list(new QueryWrapper<AttrAttrgroupRelation>()
                .eq(ProConsEnums.COLUMN_ATTR_GROUP_ID, attrgroupId));
        List<Long> attrIds = relations.stream().map(AttrAttrgroupRelation::getAttrId).collect(Collectors.toList());
        List<Attr> attrs = null;
        if (!ObjectUtils.isEmpty(attrIds)) {
            attrs = attrService.listByIds(attrIds);
        }
        return ResponseEntity.ok("data", attrs);
    }

    @Override
    public ResponseEntity getNotInAttrGroupList(Long attrGroupId, Map<String, Object> params) {
        AttrGroup attrGroup = this.getById(attrGroupId);
        assert ObjectUtils.isEmpty(attrGroup);
        Long catelogId = attrGroup.getCatelogId();
        List<AttrAttrgroupRelation> relations = relationService.list(new QueryWrapper<AttrAttrgroupRelation>()
                .eq(ProConsEnums.COLUMN_ATTR_GROUP_ID, attrGroupId));
        //已关联,不做展示的属性
        List<Long> attrIdList = relations.stream().map(AttrAttrgroupRelation::getAttrId).collect(Collectors.toList());
        //同一分类下排除不做展示后的属性
        List<Long> attrs = attrService.list(new QueryWrapper<Attr>()
                .eq(ProConsEnums.COLUMN_CATELOG_ID, catelogId)
                .notIn(ProConsEnums.COLUMN_ATTR_ID, attrIdList))
                .stream().map(Attr::getAttrId)
                .collect(Collectors.toList());
        QueryWrapper<Attr> wrapper = new QueryWrapper<Attr>()
                .eq(ProConsEnums.COLUMN_CATELOG_ID, catelogId)
                .in(ProConsEnums.COLUMN_ATTR_ID, attrs);
        String key = (String) params.get("key");
        if (!StringUtils.isNullOrEmpty(key)) {
            wrapper.and(condition -> condition.eq(ProConsEnums.COLUMN_ATTR_ID, key).or().likeRight(ProConsEnums.COLUMN_ATTR_NAME, key));
        }
        IPage<Attr> iPage = new Query<Attr>().getPage(params);
        IPage<Attr> page = attrService.page(iPage, wrapper);
        return ResponseEntity.ok("page", new PageUtils(page));
    }

    @Override
    public boolean saveAttrRelationship(List<AttrAttrgroupRelation> relations) {
        return relationService.saveBatch(relations);
    }

    @Override
    public ResponseEntity getAttrByCatelogId(long catelogId) {
        //根据品类查询当前分组
        List<AttrGroup> attrGroups = this.list(new QueryWrapper<AttrGroup>().eq(ProConsEnums.COLUMN_CATELOG_ID, catelogId));
        List<Long> groupIds = attrGroups.stream().map(AttrGroup::getAttrGroupId).collect(Collectors.toList());
        if (ObjectUtils.isEmpty(groupIds)) {
            throw new SqlException("当前品类信息异常,请检查订单关联关系是否正常!");
        }

        List<AttrGroupFindAttrVo> attrVos = attrGroups.stream().map(attrGroup -> {
            AttrGroupFindAttrVo groupFindAttrVo = new AttrGroupFindAttrVo();
            BeanUtils.copyProperties(attrGroup, groupFindAttrVo);
            //根据分类查询所关联的商品属性信息
            List<AttrAttrgroupRelation> relations = relationService.list(new QueryWrapper<AttrAttrgroupRelation>()
                    .eq(ProConsEnums.COLUMN_ATTR_GROUP_ID, attrGroup.getAttrGroupId()));
            if (!ObjectUtils.isEmpty(relations)) {
                List<Long> attrIds = relations.stream().map(AttrAttrgroupRelation::getAttrId).collect(Collectors.toList());
                if (!ObjectUtils.isEmpty(attrIds)) {
                    List<Attr> attrs = attrService.listByIds(attrIds);
                    if (!ObjectUtils.isEmpty(attrs)) {
                        groupFindAttrVo.setAttrList(attrs);
                    }
                }
            }
            return groupFindAttrVo;
        }).collect(Collectors.toList());
        return ResponseEntity.ok("data", attrVos);
    }
}




