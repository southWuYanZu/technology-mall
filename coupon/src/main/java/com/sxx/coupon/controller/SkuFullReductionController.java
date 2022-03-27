package com.sxx.coupon.controller;

import com.sxx.common.to.SkuReductionTo;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SkuFullReduction;
import com.sxx.coupon.service.SkuFullReductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_sku_full_reduction(商品满减信息)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:37:02
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(商品满减信息)")
@RequestMapping("coupon/skuFullReduction")
public class SkuFullReductionController {

    private final SkuFullReductionService skuFullReductionService;

    /**
     * 查询(商品满减信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(商品满减信息)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return skuFullReductionService.queryPage(params);
    }

    /**
     * (商品满减信息)详细信息
     *
     * @param skuFullReductionId (商品满减信息)Id
     * @return (商品满减信息)详情信息
     */
    @GetMapping("info/{skuFullReductionId}")
    @ApiOperation("(商品满减信息)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long skuFullReductionId) {
        SkuFullReduction skuFullReduction = skuFullReductionService.getById(skuFullReductionId);
        return ResponseEntity.ok("data", skuFullReduction);
    }

    /**
     * (商品满减信息)批量新增或修改
     *
     * @param skuFullReductions 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(商品满减信息)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<SkuFullReduction> skuFullReductions) {
        boolean flag = skuFullReductionService.saveOrUpdateBatch(skuFullReductions);
        return flag ? ResponseEntity.ok("(商品满减信息)批量变更成功") : ResponseEntity.error("(商品满减信息)批量变更失败");
    }

    /**
     * (商品满减信息)新增
     *
     * @param skuFullReduction (商品满减信息)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(商品满减信息)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SkuFullReduction skuFullReduction) {
        boolean flag = skuFullReductionService.saveOrUpdate(skuFullReduction);
        return flag ? ResponseEntity.ok("(商品满减信息)新增成功") : ResponseEntity.error("(商品满减信息)新增失败");
    }

    /**
     * 发布商品保存sku 满减信息
     *
     * @param skuReductionTo (商品满减信息)信息
     * @return 新增状态
     */
    @PostMapping("saveInfo")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo) {
        skuFullReductionService.saveSkuReduction(skuReductionTo);
        return ResponseEntity.ok();
    }

    /**
     * (商品满减信息)更新
     *
     * @param skuFullReduction (商品满减信息)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(商品满减信息)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody SkuFullReduction skuFullReduction) {
        boolean flag = skuFullReductionService.updateById(skuFullReduction);
        return flag ? ResponseEntity.ok("(商品满减信息)更新成功") : ResponseEntity.error("(商品满减信息)更新失败");
    }

    /**
     * 批量更新(商品满减信息)
     *
     * @param skuFullReductions (商品满减信息)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(商品满减信息)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<SkuFullReduction> skuFullReductions) {
        boolean flag = skuFullReductionService.updateBatchById(skuFullReductions);
        return flag ? ResponseEntity.ok("批量更新(商品满减信息)成功") : ResponseEntity.error("批量更新(商品满减信息)失败");
    }

    /**
     * (商品满减信息)删除
     *
     * @param deleteIds 删除(商品满减信息)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(商品满减信息)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = skuFullReductionService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(商品满减信息)删除成功") : ResponseEntity.error("(商品满减信息)删除失败");
    }
}