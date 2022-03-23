package com.sxx.coupon.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_seckill_sku_notice(秒杀商品通知订阅)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(秒杀商品通知订阅)")
@RequestMapping("seckillSkuNotice")
public class SeckillSkuNoticeController {

    private final SeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * 查询(秒杀商品通知订阅)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(秒杀商品通知订阅)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return seckillSkuNoticeService.queryPage(params);
    }

    /**
     * (秒杀商品通知订阅)详细信息
     *
     * @param seckillSkuNoticeId (秒杀商品通知订阅)Id
     * @return (秒杀商品通知订阅)详情信息
     */
    @GetMapping("info/{seckillSkuNoticeId}")
    @ApiOperation("(秒杀商品通知订阅)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long seckillSkuNoticeId) {
        SeckillSkuNotice seckillSkuNotice = seckillSkuNoticeService.getById(seckillSkuNoticeId);
        return ResponseEntity.ok("data", seckillSkuNotice);
    }

    /**
     * (秒杀商品通知订阅)批量新增或修改
     *
     * @param seckillSkuNotices 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(秒杀商品通知订阅)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<SeckillSkuNotice> seckillSkuNotices) {
        boolean flag = seckillSkuNoticeService.saveOrUpdateBatch(seckillSkuNotices);
        return flag ? ResponseEntity.ok("(秒杀商品通知订阅)批量变更成功") : ResponseEntity.error("(秒杀商品通知订阅)批量变更失败");
    }

    /**
     * (秒杀商品通知订阅)新增
     *
     * @param seckillSkuNotice (秒杀商品通知订阅)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(秒杀商品通知订阅)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SeckillSkuNotice seckillSkuNotice) {
        boolean flag = seckillSkuNoticeService.saveOrUpdate(seckillSkuNotice);
        return flag ? ResponseEntity.ok("(秒杀商品通知订阅)新增成功") : ResponseEntity.error("(秒杀商品通知订阅)新增失败");
    }

    /**
     * (秒杀商品通知订阅)更新
     *
     * @param seckillSkuNotice (秒杀商品通知订阅)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(秒杀商品通知订阅)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody SeckillSkuNotice seckillSkuNotice) {
        boolean flag = seckillSkuNoticeService.updateById(seckillSkuNotice);
        return flag ? ResponseEntity.ok("(秒杀商品通知订阅)更新成功") : ResponseEntity.error("(秒杀商品通知订阅)更新失败");
    }

    /**
     * 批量更新(秒杀商品通知订阅)
     *
     * @param seckillSkuNotices (秒杀商品通知订阅)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(秒杀商品通知订阅)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<SeckillSkuNotice> seckillSkuNotices) {
        boolean flag = seckillSkuNoticeService.updateBatchById(seckillSkuNotices);
        return flag ? ResponseEntity.ok("批量更新(秒杀商品通知订阅)成功") : ResponseEntity.error("批量更新(秒杀商品通知订阅)失败");
    }

    /**
     * (秒杀商品通知订阅)删除
     *
     * @param deleteIds 删除(秒杀商品通知订阅)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(秒杀商品通知订阅)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = seckillSkuNoticeService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(秒杀商品通知订阅)删除成功") : ResponseEntity.error("(秒杀商品通知订阅)删除失败");
    }
}