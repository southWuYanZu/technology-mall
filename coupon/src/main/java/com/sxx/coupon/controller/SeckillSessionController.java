package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SeckillSession;
import com.sxx.coupon.service.SeckillSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_seckill_session(秒杀活动场次)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(秒杀活动场次)")
@RequestMapping("seckillSession")
public class SeckillSessionController {

    private final SeckillSessionService seckillSessionService;

    /**
     * 查询(秒杀活动场次)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(秒杀活动场次)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return seckillSessionService.queryPage(params);
    }

    /**
     * (秒杀活动场次)详细信息
     *
     * @param seckillSessionId (秒杀活动场次)Id
     * @return (秒杀活动场次)详情信息
     */
    @GetMapping("info/{seckillSessionId}")
    @ApiOperation("(秒杀活动场次)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long seckillSessionId) {
        SeckillSession seckillSession = seckillSessionService.getById(seckillSessionId);
        return ResponseEntity.ok("data", seckillSession);
    }

    /**
     * (秒杀活动场次)批量新增或修改
     *
     * @param seckillSessions 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(秒杀活动场次)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<SeckillSession> seckillSessions) {
        boolean flag = seckillSessionService.saveOrUpdateBatch(seckillSessions);
        return flag ? ResponseEntity.ok("(秒杀活动场次)批量变更成功") : ResponseEntity.error("(秒杀活动场次)批量变更失败");
    }

    /**
     * (秒杀活动场次)新增
     *
     * @param seckillSession (秒杀活动场次)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(秒杀活动场次)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SeckillSession seckillSession) {
        boolean flag = seckillSessionService.saveOrUpdate(seckillSession);
        return flag ? ResponseEntity.ok("(秒杀活动场次)新增成功") : ResponseEntity.error("(秒杀活动场次)新增失败");
    }

    /**
     * (秒杀活动场次)更新
     *
     * @param seckillSession (秒杀活动场次)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(秒杀活动场次)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody SeckillSession seckillSession) {
        boolean flag = seckillSessionService.updateById(seckillSession);
        return flag ? ResponseEntity.ok("(秒杀活动场次)更新成功") : ResponseEntity.error("(秒杀活动场次)更新失败");
    }

    /**
     * 批量更新(秒杀活动场次)
     *
     * @param seckillSessions (秒杀活动场次)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(秒杀活动场次)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<SeckillSession> seckillSessions) {
        boolean flag = seckillSessionService.updateBatchById(seckillSessions);
        return flag ? ResponseEntity.ok("批量更新(秒杀活动场次)成功") : ResponseEntity.error("批量更新(秒杀活动场次)失败");
    }

    /**
     * (秒杀活动场次)删除
     *
     * @param deleteIds 删除(秒杀活动场次)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(秒杀活动场次)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = seckillSessionService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(秒杀活动场次)删除成功") : ResponseEntity.error("(秒杀活动场次)删除失败");
    }
}