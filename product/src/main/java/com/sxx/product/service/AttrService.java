package com.sxx.product.service;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.Attr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * @author shenxianxin
 * 针对表【pms_attr(商品属性)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface AttrService extends IService<Attr> {

    /**
     * 保存商品属性以及相关信息
     *
     * @param attrVo 属性信息
     * @return flag
     */
    boolean saveDetail(AttrVo attrVo);

    /**
     * 属性分组列表
     *
     * @param params    查询条件
     * @param attrType  商品类型
     * @param catelogId 查询分组
     * @return 结果集
     */
    ResponseEntity queryPage(Map<String, Object> params, String attrType, Long catelogId);

    /**
     * 根据id 查询详细信息
     *
     * @param attrId 商品id
     * @return 成功状态
     */
    ResponseEntity getInfoById(Long attrId);

    /**
     * 属性更新
     *
     * @param attrVo 更新内容
     * @return 更新状态
     */
    boolean updateDetail(AttrVo attrVo);

    /**
     * 删除商品属性
     *
     * @param attrIds 属性ids
     * @return 是否删除成功
     */
    boolean deleteByIds(Long[] attrIds);

    /**
     * 在指定的所有属性集合里面，挑出检索属性
     *
     * @param attrIds 属性ID
     * @return 符合条件属性
     */
    List<Long> selectSearchAttrs(List<Long> attrIds);

    List<Attr> getRelationAttr(Long attrGroupId);
}
