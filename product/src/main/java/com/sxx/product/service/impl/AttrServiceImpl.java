package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.Attr;
import com.sxx.product.entity.AttrAttrgroupRelation;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.entity.Category;
import com.sxx.product.enums.ProConsEnums;
import com.sxx.product.mapper.AttrAttrgroupRelationMapper;
import com.sxx.product.mapper.AttrGroupMapper;
import com.sxx.product.mapper.AttrMapper;
import com.sxx.product.mapper.CategoryMapper;
import com.sxx.product.service.AttrService;
import com.sxx.product.service.CategoryService;
import com.sxx.product.vo.AttrResponseVo;
import com.sxx.product.vo.AttrVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author shenxianxin
 * 针对表【pms_attr(商品属性)】的数据库操作Service实现
 * @since 2021-12-02 18:42:19
 */
@Service
@RequiredArgsConstructor
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr>
        implements AttrService {
    private final AttrAttrgroupRelationMapper relationMapper;

    private final CategoryService categoryService;

    private final AttrGroupMapper attrGroupMapper;

    private final CategoryMapper categoryMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveDetail(AttrVo attrVo) {
        Attr attr = new Attr();
        BeanUtils.copyProperties(attrVo, attr);
        boolean flag = this.save(attr);
        AttrAttrgroupRelation relation = new AttrAttrgroupRelation();
        //商品属性才具有分组信息
        if (!StringUtils.isEmpty(attrVo.getAttrGroupId()) && ProConsEnums.AttrEnum.ATTR_TYPE_BASE.getCode() == attrVo.getAttrType()) {
            relation.setAttrGroupId(attrVo.getAttrGroupId());
            relation.setAttrId(attr.getAttrId());
            relationMapper.insert(relation);
        }
        return flag;
    }

    @Override
    public ResponseEntity queryPage(Map<String, Object> params, String attrType, Long catelogId) {
        String key = (String) params.get("key");
        QueryWrapper<Attr> wrapper = new QueryWrapper<>();
        wrapper.eq(ProConsEnums.COLUMN_ATTR_TYPE, "base".equals(attrType) ? 1 : 0);
        if (catelogId != 0) {
            wrapper.eq(ProConsEnums.COLUMN_CATELOG_ID, catelogId);
        }
        if (!StringUtils.isEmpty(key)) {
            wrapper.and(condition -> condition.likeRight(ProConsEnums.COLUMN_ATTR_NAME, key)
                    .or().eq(ProConsEnums.COLUMN_ATTR_ID, key));
        }

        IPage<Attr> iPage = this.page(new Query<Attr>().getPage(params), wrapper);
        List<Attr> records = iPage.getRecords();

        List<AttrResponseVo> attrResponseVoList = records.stream().map(attr -> {
            AttrResponseVo attrResponseVo = new AttrResponseVo();
            BeanUtils.copyProperties(attr, attrResponseVo);
            //商品才具有分组信息
            if (attr.getAttrType() == ProConsEnums.AttrEnum.ATTR_TYPE_BASE.getCode()) {
                //获取分组信息
                AttrAttrgroupRelation relation = relationMapper.selectOne(new QueryWrapper<AttrAttrgroupRelation>()
                        .eq(ProConsEnums.COLUMN_ATTR_ID, attr.getAttrId()));
                if (relation != null) {
                    AttrGroup attrGroup = attrGroupMapper.selectById(relation.getAttrGroupId());
                    if (!ObjectUtils.isEmpty(attrGroup)) {
                        attr.setCatelogId(attrGroup.getCatelogId());
                        attrResponseVo.setAttrGroupName(attrGroup.getAttrGroupName());
                    }
                }
            }
            //获取分类信息
            Category category = categoryMapper.selectById(attr.getCatelogId());
            if (category != null) {
                attrResponseVo.setCatelogName(category.getName());
            }
            return attrResponseVo;
        }).collect(Collectors.toList());

        PageUtils pageUtils = new PageUtils(iPage);
        pageUtils.setList(attrResponseVoList);
        return ResponseEntity.ok("page", pageUtils);
    }

    @Override
    public ResponseEntity getInfoById(Long attrId) {
        AttrResponseVo responseVo = new AttrResponseVo();
        Attr attr = this.getById(attrId);
        BeanUtils.copyProperties(attr, responseVo);
        //获取分组信息
        AttrAttrgroupRelation relation = relationMapper.selectOne(new QueryWrapper<AttrAttrgroupRelation>()
                .eq(ProConsEnums.COLUMN_ATTR_ID, attr.getAttrId()));
        if (!ObjectUtils.isEmpty(relation)) {
            Long attrGroupId = relation.getAttrGroupId();
            AttrGroup attrGroup = attrGroupMapper.selectById(attrGroupId);
            if (!ObjectUtils.isEmpty(attrGroup)) {
                responseVo.setAttrGroupId(attrGroupId);
                responseVo.setAttrGroupName(attrGroup.getAttrGroupName());
            }
        }
        //获取分类信息
        Long[] idPath = categoryService.findCategoryPathById(attr.getCatelogId());
        responseVo.setCatelogPath(idPath);
        Category category = categoryService.getById(attr.getCatelogId());
        if (!ObjectUtils.isEmpty(category)) {
            responseVo.setCatelogName(category.getName());
        }
        return ResponseEntity.ok("attr", responseVo);
    }

    @Override
    public boolean updateDetail(AttrVo attrVo) {
        Attr attr = new Attr();
        BeanUtils.copyProperties(attrVo, attr);
        AttrAttrgroupRelation relation = new AttrAttrgroupRelation();
        boolean state = this.updateById(attr);
        //更新关联关系表
        if (ProConsEnums.AttrEnum.ATTR_TYPE_BASE.getCode() == attrVo.getAttrType()) {
            relation.setAttrId(attrVo.getAttrId());
            relation.setAttrGroupId(attrVo.getAttrGroupId());
            int update = relationMapper.update(relation, new QueryWrapper<AttrAttrgroupRelation>()
                    .eq(ProConsEnums.COLUMN_ATTR_ID, attrVo.getAttrId()));
            if (update == 0) {
                relationMapper.insert(relation);
            }
        }

        //更新分组关系表
        AttrGroup attrGroup = new AttrGroup();
        attrGroup.setAttrGroupId(attrVo.getAttrGroupId());
        attrGroup.setCatelogId(attrVo.getCatelogId());
        attrGroupMapper.update(attrGroup, new QueryWrapper<AttrGroup>()
                .eq(ProConsEnums.COLUMN_ATTR_GROUP_ID, attrVo.getAttrGroupId()));
        return state;
    }

    @Override
    public boolean deleteByIds(Long[] attrIds) {
        List<Attr> attrs = baseMapper.selectBatchIds(Arrays.asList(attrIds));
        boolean state = this.removeByIds(Arrays.asList(attrIds));
        relationMapper.deleteBatchByAttrIds(attrs);
        List<Long> cateIds = attrs.stream().map(Attr::getCatelogId).collect(Collectors.toList());
        attrGroupMapper.deleteBatchByCatelogIds(cateIds);
        return state;
    }

    @Override
    public List<Long> selectSearchAttrs(List<Long> attrIds) {
        QueryWrapper<Attr> wrapper = new QueryWrapper<>();
        wrapper.in("id",attrIds).eq("search_type",1);
        return this.baseMapper.selectList(wrapper).stream().map(Attr::getAttrId).collect(Collectors.toList());
    }
}




