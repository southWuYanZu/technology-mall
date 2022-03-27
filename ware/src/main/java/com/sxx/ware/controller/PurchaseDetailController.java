package com.sxx.ware.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.PurchaseDetail;
import com.sxx.ware.service.PurchaseDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【wms_purchase_detail】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "")
@RequestMapping("purchaseDetail")
public class PurchaseDetailController {

    private final PurchaseDetailService purchaseDetailService;

    /**
     * 查询列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return purchaseDetailService.queryPage(params);
    }

    /**
     * 详细信息
     *
     * @param purchaseDetailId Id
     * @return 详情信息
     */
    @GetMapping("info/{purchaseDetailId}")
    @ApiOperation("详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long purchaseDetailId) {
        PurchaseDetail purchaseDetail = purchaseDetailService.getById(purchaseDetailId);
        return ResponseEntity.ok("data", purchaseDetail);
    }

    /**
     * 批量新增或修改
     *
     * @param purchaseDetails 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<PurchaseDetail> purchaseDetails) {
        boolean flag = purchaseDetailService.saveOrUpdateBatch(purchaseDetails);
        return flag ? ResponseEntity.ok("批量变更成功") : ResponseEntity.error("批量变更失败");
    }

    /**
     * 新增
     *
     * @param purchaseDetail 信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody PurchaseDetail purchaseDetail) {
        boolean flag = purchaseDetailService.saveOrUpdate(purchaseDetail);
        return flag ? ResponseEntity.ok("新增成功") : ResponseEntity.error("新增失败");
    }

    /**
     * 更新
     *
     * @param purchaseDetail 信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody PurchaseDetail purchaseDetail) {
        boolean flag = purchaseDetailService.updateById(purchaseDetail);
        return flag ? ResponseEntity.ok("更新成功") : ResponseEntity.error("更新失败");
    }

    /**
     * 批量更新
     *
     * @param purchaseDetails 信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<PurchaseDetail> purchaseDetails) {
        boolean flag = purchaseDetailService.updateBatchById(purchaseDetails);
        return flag ? ResponseEntity.ok("批量更新成功") : ResponseEntity.error("批量更新失败");
    }

    /**
     * 删除
     *
     * @param deleteIds 删除集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = purchaseDetailService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("删除成功") : ResponseEntity.error("删除失败");
    }
}