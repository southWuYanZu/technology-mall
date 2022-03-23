package com.sxx.coupon.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_seckill_promotion(秒杀活动)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(秒杀活动)")
@RequestMapping("seckillPromotion")
public class SeckillPromotionController {

    private final SeckillPromotionService seckillPromotionService;

    /**
     * 查询(秒杀活动)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(秒杀活动)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return seckillPromotionService.queryPage(params);
    }

    /**
     * (秒杀活动)详细信息
     *
     * @param seckillPromotionId (秒杀活动)Id
     * @return (秒杀活动)详情信息
     */
    @GetMapping("info/{seckillPromotionId}")
    @ApiOperation("(秒杀活动)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long seckillPromotionId) {
        SeckillPromotion seckillPromotion = seckillPromotionService.getById(seckillPromotionId);
        return ResponseEntity.ok("data", seckillPromotion);
    }

    /**
     * (秒杀活动)批量新增或修改
     *
     * @param seckillPromotions 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(秒杀活动)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<SeckillPromotion> seckillPromotions) {
        boolean flag = seckillPromotionService.saveOrUpdateBatch(seckillPromotions);
        return flag ? ResponseEntity.ok("(秒杀活动)批量变更成功") : ResponseEntity.error("(秒杀活动)批量变更失败");
    }

    /**
     * (秒杀活动)新增
     *
     * @param seckillPromotion (秒杀活动)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(秒杀活动)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SeckillPromotion seckillPromotion) {
        boolean flag = seckillPromotionService.saveOrUpdate(seckillPromotion);
        return flag ? ResponseEntity.ok("(秒杀活动)新增成功") : ResponseEntity.error("(秒杀活动)新增失败");
    }

    /**
     * (秒杀活动)更新
     *
     * @param seckillPromotion (秒杀活动)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(秒杀活动)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody SeckillPromotion seckillPromotion) {
        boolean flag = seckillPromotionService.updateById(seckillPromotion);
        return flag ? ResponseEntity.ok("(秒杀活动)更新成功") : ResponseEntity.error("(秒杀活动)更新失败");
    }

    /**
     * 批量更新(秒杀活动)
     *
     * @param seckillPromotions (秒杀活动)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(秒杀活动)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<SeckillPromotion> seckillPromotions) {
        boolean flag = seckillPromotionService.updateBatchById(seckillPromotions);
        return flag ? ResponseEntity.ok("批量更新(秒杀活动)成功") : ResponseEntity.error("批量更新(秒杀活动)失败");
    }

    /**
     * (秒杀活动)删除
     *
     * @param deleteIds 删除(秒杀活动)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(秒杀活动)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = seckillPromotionService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(秒杀活动)删除成功") : ResponseEntity.error("(秒杀活动)删除失败");
    }
}