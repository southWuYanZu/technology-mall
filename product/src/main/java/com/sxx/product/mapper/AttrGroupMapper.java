package com.sxx.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxx.product.entity.AttrGroup;
import com.sxx.product.vo.SpuItemAttrGroupVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shenxianxin
*  针对表【pms_attr_group(属性分组)】的数据库操作Mapper
* @since 2021-12-02 18:42:19
* @Entity com.sxx.product.entity.AttrGroup
*/
public interface AttrGroupMapper extends BaseMapper<AttrGroup> {

    /**
     * 根据品类Id删除对应分组信息
     * @param cateIds 品类id
     * @return 删除状态
     */
    boolean deleteBatchByCatelogIds(List<Long> cateIds);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(@Param("spuId") Long spuId, @Param("catalogId") Long catalogId);
}




