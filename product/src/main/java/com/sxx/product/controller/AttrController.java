package com.sxx.product.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.product.entity.ProductAttrValue;
import com.sxx.product.service.AttrService;
import com.sxx.product.service.ProductAttrValueService;
import com.sxx.product.vo.AttrVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 商品属性
 *
 * @author Mr.shen
 * @since 2022/3/8
 */
@Api("商品属性")
@RestController
@RequiredArgsConstructor
@RequestMapping("product/attr")
public class AttrController {

    private final AttrService attrService;

    private final ProductAttrValueService productAttrValueService;

    /**
     * 查询商品属性列表 [如果attrId 为 0 则判定为全部查询]
     *
     * @param params    查询条件
     * @param attrType  商品类型
     * @param catelogId 分组id
     * @return 查询结果集
     */
    @GetMapping("{attrType}/list/{catelogId}")
    @ApiOperation("商品属性列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params,
                               @PathVariable String attrType,
                               @PathVariable Long catelogId) {
        return attrService.queryPage(params, attrType, catelogId);
    }

    /**
     * 新增商品属性
     *
     * @param attrVo 属性信息
     * @return 添加状态
     */
    @PostMapping("save")
    @ApiOperation("新增属性")
    public ResponseEntity save(@RequestBody AttrVo attrVo) {
        boolean flag = attrService.saveDetail(attrVo);
        return flag ? ResponseEntity.ok("属性添加成功") : ResponseEntity.error("属性添加失败");
    }

    /**
     * 根据id 查询详细信息
     *
     * @param attrId 商品id
     * @return 详细信息
     */
    @GetMapping("info/{attrId}")
    @ApiOperation(("商品属性信息"))
    public ResponseEntity info(@PathVariable Long attrId) {
        return attrService.getInfoById(attrId);
    }


    /**
     * 根据spuId 获取规格参数
     *
     * @param spuId spuId
     * @return 当前spu的规格参数
     */
    @ApiOperation("获取规格参数")
    @GetMapping("base/listforspu/{spuId}")
    public ResponseEntity baseAttrListForSpu(@PathVariable String spuId) {
        return productAttrValueService.baseAttrListForSpu(spuId);
    }

    /**
     * 属性更新
     *
     * @param attrVo 更新内容
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("属性更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody AttrVo attrVo) {
        boolean flag = attrService.updateDetail(attrVo);
        return flag ? ResponseEntity.ok("属性修改成功") : ResponseEntity.error("属性修改失败");
    }

    /**
     * 更新规格属性信息
     *
     * @param spuId    spuId
     * @param entities 更新规格属性集
     * @return 更新状态
     */
    @PostMapping("/update/{spuId}")
    public ResponseEntity updateSpuAttr(@PathVariable("spuId") Long spuId,
                           @RequestBody List<ProductAttrValue> entities) {

        return productAttrValueService.updateSpuAttr(spuId, entities);

    }

    /**
     * 删除商品属性
     *
     * @param attrIds 属性ids
     * @return 是否删除成功
     */
    @PostMapping("delete")
    @ApiOperation("属性删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody Long[] attrIds) {
        boolean flag = attrService.deleteByIds(attrIds);
        return flag ? ResponseEntity.ok("属性删除成功") : ResponseEntity.error("属性删除失败");
    }
}