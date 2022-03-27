package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SkuLadder;
import com.sxx.coupon.service.SkuLadderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_sku_ladder(商品阶梯价格)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(商品阶梯价格)")
@RequestMapping("skuLadder")
public class SkuLadderController {

    private final SkuLadderService skuLadderService;

    /**
     * 查询(商品阶梯价格)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(商品阶梯价格)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return skuLadderService.queryPage(params);
    }

    /**
     * (商品阶梯价格)详细信息
     *
     * @param skuLadderId (商品阶梯价格)Id
     * @return (商品阶梯价格)详情信息
     */
    @GetMapping("info/{skuLadderId}")
    @ApiOperation("(商品阶梯价格)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long skuLadderId) {
        SkuLadder skuLadder = skuLadderService.getById(skuLadderId);
        return ResponseEntity.ok("data", skuLadder);
    }

    /**
     * (商品阶梯价格)批量新增或修改
     *
     * @param skuLadders 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(商品阶梯价格)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<SkuLadder> skuLadders) {
        boolean flag = skuLadderService.saveOrUpdateBatch(skuLadders);
        return flag ? ResponseEntity.ok("(商品阶梯价格)批量变更成功") : ResponseEntity.error("(商品阶梯价格)批量变更失败");
    }

    /**
     * (商品阶梯价格)新增
     *
     * @param skuLadder (商品阶梯价格)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(商品阶梯价格)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SkuLadder skuLadder) {
        boolean flag = skuLadderService.saveOrUpdate(skuLadder);
        return flag ? ResponseEntity.ok("(商品阶梯价格)新增成功") : ResponseEntity.error("(商品阶梯价格)新增失败");
    }

    /**
     * (商品阶梯价格)更新
     *
     * @param skuLadder (商品阶梯价格)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(商品阶梯价格)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody SkuLadder skuLadder) {
        boolean flag = skuLadderService.updateById(skuLadder);
        return flag ? ResponseEntity.ok("(商品阶梯价格)更新成功") : ResponseEntity.error("(商品阶梯价格)更新失败");
    }

    /**
     * 批量更新(商品阶梯价格)
     *
     * @param skuLadders (商品阶梯价格)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(商品阶梯价格)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<SkuLadder> skuLadders) {
        boolean flag = skuLadderService.updateBatchById(skuLadders);
        return flag ? ResponseEntity.ok("批量更新(商品阶梯价格)成功") : ResponseEntity.error("批量更新(商品阶梯价格)失败");
    }

    /**
     * (商品阶梯价格)删除
     *
     * @param deleteIds 删除(商品阶梯价格)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(商品阶梯价格)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = skuLadderService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(商品阶梯价格)删除成功") : ResponseEntity.error("(商品阶梯价格)删除失败");
    }
}