package com.sxx.ware.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareSku;
import com.sxx.ware.service.WareSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【wms_ware_sku(商品库存)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(商品库存)")
@RequestMapping("ware/waresku")
public class WareSkuController {

    private final WareSkuService wareSkuService;

    /**
     * 查询(商品库存)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(商品库存)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return wareSkuService.queryPage(params);
    }

    /**
     * (商品库存)详细信息
     *
     * @param wareSkuId (商品库存)Id
     * @return (商品库存)详情信息
     */
    @GetMapping("info/{wareSkuId}")
    @ApiOperation("(商品库存)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long wareSkuId) {
        WareSku wareSku = wareSkuService.getById(wareSkuId);
        return ResponseEntity.ok("data", wareSku);
    }

    /**
     * (商品库存)批量新增或修改
     *
     * @param wareSkus 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(商品库存)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<WareSku> wareSkus) {
        boolean flag = wareSkuService.saveOrUpdateBatch(wareSkus);
        return flag ? ResponseEntity.ok("(商品库存)批量变更成功") : ResponseEntity.error("(商品库存)批量变更失败");
    }

    /**
     * (商品库存)新增
     *
     * @param wareSku (商品库存)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(商品库存)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody WareSku wareSku) {
        boolean flag = wareSkuService.saveOrUpdate(wareSku);
        return flag ? ResponseEntity.ok("(商品库存)新增成功") : ResponseEntity.error("(商品库存)新增失败");
    }

    /**
     * (商品库存)更新
     *
     * @param wareSku (商品库存)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(商品库存)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody WareSku wareSku) {
        boolean flag = wareSkuService.updateById(wareSku);
        return flag ? ResponseEntity.ok("(商品库存)更新成功") : ResponseEntity.error("(商品库存)更新失败");
    }

    /**
     * 批量更新(商品库存)
     *
     * @param wareSkus (商品库存)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(商品库存)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<WareSku> wareSkus) {
        boolean flag = wareSkuService.updateBatchById(wareSkus);
        return flag ? ResponseEntity.ok("批量更新(商品库存)成功") : ResponseEntity.error("批量更新(商品库存)失败");
    }

    /**
     * (商品库存)删除
     *
     * @param deleteIds 删除(商品库存)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(商品库存)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = wareSkuService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(商品库存)删除成功") : ResponseEntity.error("(商品库存)删除失败");
    }
}