package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.product.entity.SkuSaleAttrValue;
import com.sxx.product.mapper.SkuSaleAttrValueMapper;
import com.sxx.product.service.SkuSaleAttrValueService;
import com.sxx.product.vo.SkuItemSaleAttrVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author shenxianxin
*  针对表【pms_sku_sale_attr_value(sku销售属性&值)】的数据库操作Service实现
* @since 2021-12-02 18:42:19
*/
@Service
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValue>
    implements SkuSaleAttrValueService{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuSaleAttrValue> page = this.page(
                new Query<SkuSaleAttrValue>().getPage(params),
                new QueryWrapper<SkuSaleAttrValue>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId) {

        List<SkuItemSaleAttrVo> saleAttrVos = baseMapper.getSaleAttrBySpuId(spuId);

        return saleAttrVos;
    }

    @Override
    public List<String> getSkuSaleAttrValuesAsStringList(Long skuId) {

        List<String> stringList = baseMapper.getSkuSaleAttrValuesAsStringList(skuId);

        return stringList;
    }

}




