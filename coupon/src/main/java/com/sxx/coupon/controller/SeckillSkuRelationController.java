package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SeckillSkuRelation;
import com.sxx.coupon.service.SeckillSkuRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_seckill_sku_relation(秒杀活动商品关联)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(秒杀活动商品关联)")
@RequestMapping("seckillSkuRelation")
public class SeckillSkuRelationController {

    private final SeckillSkuRelationService seckillSkuRelationService;

    /**
     * 查询(秒杀活动商品关联)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(秒杀活动商品关联)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return seckillSkuRelationService.queryPage(params);
    }

    /**
     * (秒杀活动商品关联)详细信息
     *
     * @param seckillSkuRelationId (秒杀活动商品关联)Id
     * @return (秒杀活动商品关联)详情信息
     */
    @GetMapping("info/{seckillSkuRelationId}")
    @ApiOperation("(秒杀活动商品关联)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long seckillSkuRelationId) {
        SeckillSkuRelation seckillSkuRelation = seckillSkuRelationService.getById(seckillSkuRelationId);
        return ResponseEntity.ok("data", seckillSkuRelation);
    }

    /**
     * (秒杀活动商品关联)批量新增或修改
     *
     * @param seckillSkuRelations 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(秒杀活动商品关联)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<SeckillSkuRelation> seckillSkuRelations) {
        boolean flag = seckillSkuRelationService.saveOrUpdateBatch(seckillSkuRelations);
        return flag ? ResponseEntity.ok("(秒杀活动商品关联)批量变更成功") : ResponseEntity.error("(秒杀活动商品关联)批量变更失败");
    }

    /**
     * (秒杀活动商品关联)新增
     *
     * @param seckillSkuRelation (秒杀活动商品关联)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(秒杀活动商品关联)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SeckillSkuRelation seckillSkuRelation) {
        boolean flag = seckillSkuRelationService.saveOrUpdate(seckillSkuRelation);
        return flag ? ResponseEntity.ok("(秒杀活动商品关联)新增成功") : ResponseEntity.error("(秒杀活动商品关联)新增失败");
    }

    /**
     * (秒杀活动商品关联)更新
     *
     * @param seckillSkuRelation (秒杀活动商品关联)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(秒杀活动商品关联)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody SeckillSkuRelation seckillSkuRelation) {
        boolean flag = seckillSkuRelationService.updateById(seckillSkuRelation);
        return flag ? ResponseEntity.ok("(秒杀活动商品关联)更新成功") : ResponseEntity.error("(秒杀活动商品关联)更新失败");
    }

    /**
     * 批量更新(秒杀活动商品关联)
     *
     * @param seckillSkuRelations (秒杀活动商品关联)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(秒杀活动商品关联)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<SeckillSkuRelation> seckillSkuRelations) {
        boolean flag = seckillSkuRelationService.updateBatchById(seckillSkuRelations);
        return flag ? ResponseEntity.ok("批量更新(秒杀活动商品关联)成功") : ResponseEntity.error("批量更新(秒杀活动商品关联)失败");
    }

    /**
     * (秒杀活动商品关联)删除
     *
     * @param deleteIds 删除(秒杀活动商品关联)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(秒杀活动商品关联)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = seckillSkuRelationService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(秒杀活动商品关联)删除成功") : ResponseEntity.error("(秒杀活动商品关联)删除失败");
    }
}