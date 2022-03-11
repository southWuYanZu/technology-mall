package com.sxx.member.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_integration_change_history(积分变化历史记录)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(积分变化历史记录)")
@RequestMapping("IntegrationChangeHistory")
public class IntegrationChangeHistoryController {

    private final IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 查询(积分变化历史记录)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(积分变化历史记录)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return integrationChangeHistoryService.queryPage(params);
    }

    /**
     * (积分变化历史记录)详细信息
     *
     * @param integrationChangeHistoryId (积分变化历史记录)Id
     * @return (积分变化历史记录)详情信息
     */
    @GetMapping("info/{integrationChangeHistoryId}")
    @ApiOperation("(积分变化历史记录)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long integrationChangeHistoryId) {
        IntegrationChangeHistory integrationChangeHistory = integrationChangeHistoryService.getById(integrationChangeHistoryId);
        return ResponseEntity.ok("data", integrationChangeHistory);
    }

    /**
     * (积分变化历史记录)批量新增或修改
     *
     * @param integrationChangeHistorys 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(积分变化历史记录)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<IntegrationChangeHistory> integrationChangeHistorys) {
        boolean flag = integrationChangeHistoryService.saveOrUpdateBatch(integrationChangeHistorys);
        return flag ? ResponseEntity.ok("(积分变化历史记录)批量变更成功") : ResponseEntity.error("(积分变化历史记录)批量变更失败");
    }

    /**
     * (积分变化历史记录)新增
     *
     * @param integrationChangeHistory (积分变化历史记录)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(积分变化历史记录)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        boolean flag = integrationChangeHistoryService.saveOrUpdate(integrationChangeHistory);
        return flag ? ResponseEntity.ok("(积分变化历史记录)新增成功") : ResponseEntity.error("(积分变化历史记录)新增失败");
    }

    /**
     * (积分变化历史记录)更新
     *
     * @param integrationChangeHistory (积分变化历史记录)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(积分变化历史记录)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        boolean flag = integrationChangeHistoryService.updateById(integrationChangeHistory);
        return flag ? ResponseEntity.ok("(积分变化历史记录)更新成功") : ResponseEntity.error("(积分变化历史记录)更新失败");
    }

    /**
     * 批量更新(积分变化历史记录)
     *
     * @param integrationChangeHistorys (积分变化历史记录)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(积分变化历史记录)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<IntegrationChangeHistory> integrationChangeHistorys) {
        boolean flag = integrationChangeHistoryService.updateBatchById(integrationChangeHistorys);
        return flag ? ResponseEntity.ok("批量更新(积分变化历史记录)成功") : ResponseEntity.error("批量更新(积分变化历史记录)失败");
    }

    /**
     * (积分变化历史记录)删除
     *
     * @param deleteIds 删除(积分变化历史记录)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(积分变化历史记录)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = integrationChangeHistoryService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(积分变化历史记录)删除成功") : ResponseEntity.error("(积分变化历史记录)删除失败");
    }
}