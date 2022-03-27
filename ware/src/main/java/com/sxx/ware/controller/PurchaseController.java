package com.sxx.ware.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.Purchase;
import com.sxx.ware.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【wms_purchase(采购信息)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(采购信息)")
@RequestMapping("purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    /**
     * 查询(采购信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(采购信息)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return purchaseService.queryPage(params);
    }

    /**
     * (采购信息)详细信息
     *
     * @param purchaseId (采购信息)Id
     * @return (采购信息)详情信息
     */
    @GetMapping("info/{purchaseId}")
    @ApiOperation("(采购信息)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long purchaseId) {
        Purchase purchase = purchaseService.getById(purchaseId);
        return ResponseEntity.ok("data", purchase);
    }

    /**
     * (采购信息)批量新增或修改
     *
     * @param purchases 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(采购信息)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<Purchase> purchases) {
        boolean flag = purchaseService.saveOrUpdateBatch(purchases);
        return flag ? ResponseEntity.ok("(采购信息)批量变更成功") : ResponseEntity.error("(采购信息)批量变更失败");
    }

    /**
     * (采购信息)新增
     *
     * @param purchase (采购信息)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(采购信息)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody Purchase purchase) {
        boolean flag = purchaseService.saveOrUpdate(purchase);
        return flag ? ResponseEntity.ok("(采购信息)新增成功") : ResponseEntity.error("(采购信息)新增失败");
    }

    /**
     * (采购信息)更新
     *
     * @param purchase (采购信息)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(采购信息)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody Purchase purchase) {
        boolean flag = purchaseService.updateById(purchase);
        return flag ? ResponseEntity.ok("(采购信息)更新成功") : ResponseEntity.error("(采购信息)更新失败");
    }

    /**
     * 批量更新(采购信息)
     *
     * @param purchases (采购信息)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(采购信息)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<Purchase> purchases) {
        boolean flag = purchaseService.updateBatchById(purchases);
        return flag ? ResponseEntity.ok("批量更新(采购信息)成功") : ResponseEntity.error("批量更新(采购信息)失败");
    }

    /**
     * (采购信息)删除
     *
     * @param deleteIds 删除(采购信息)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(采购信息)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = purchaseService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(采购信息)删除成功") : ResponseEntity.error("(采购信息)删除失败");
    }
}