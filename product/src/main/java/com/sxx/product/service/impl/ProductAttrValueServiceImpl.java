package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.ProductAttrValue;
import com.sxx.product.mapper.ProductAttrValueMapper;
import com.sxx.product.service.ProductAttrValueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenxianxin
 * 针对表【pms_product_attr_value(spu属性值)】的数据库操作Service实现
 * @since 2021-12-02 18:42:19
 */
@Service
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueMapper, ProductAttrValue>
        implements ProductAttrValueService {

    @Override
    public ResponseEntity baseAttrListForSpu(String spuId) {
        List<ProductAttrValue> attrValues = this.baseMapper.selectList(new QueryWrapper<ProductAttrValue>().eq("spu_id", spuId));
        return ResponseEntity.ok("data", attrValues);
    }

    @Override
    public ResponseEntity updateSpuAttr(Long spuId, List<ProductAttrValue> entities) {
        //1、删除spuId之前对应的所有属性
        this.baseMapper.delete(new QueryWrapper<ProductAttrValue>().eq("spu_id", spuId));

        //2、添加商品规格信息
        List<ProductAttrValue> collect = entities.stream().peek(item -> item.setSpuId(spuId)).collect(Collectors.toList());

        //批量新增
        this.saveBatch(collect);
        return ResponseEntity.ok();
    }
}




