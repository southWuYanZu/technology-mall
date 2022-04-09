package com.sxx.product.mapper;

import com.sxx.product.entity.SpuInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shenxianxin
 * 针对表【pms_spu_info(spu信息)】的数据库操作Mapper
 * @Entity com.sxx.product.entity.SpuInfo
 * @since 2021-12-02 18:42:19
 */
public interface SpuInfoMapper extends BaseMapper<SpuInfo> {

    /**
     * 更新spu状态
     *
     * @param spuId id
     * @param code  状态码
     */
    void updateSpuStatus(@Param("spuId") Long spuId, @Param("code") int code);
}




