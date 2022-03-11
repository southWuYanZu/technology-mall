package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.GrowthChangeHistory;
import com.sxx.member.service.GrowthChangeHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_growth_change_history(成长值变化历史记录)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(成长值变化历史记录)")
@RequestMapping("member/growthChangeHistory")
public class GrowthChangeHistoryController {

    private final GrowthChangeHistoryService growthChangeHistoryService;

    /**
     * 查询(成长值变化历史记录)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(成长值变化历史记录)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return growthChangeHistoryService.queryPage(params);
    }

    /**
     * (成长值变化历史记录)详细信息
     *
     * @param growthChangeHistoryId (成长值变化历史记录)Id
     * @return (成长值变化历史记录)详情信息
     */
    @GetMapping("info/{growthChangeHistoryId}")
    @ApiOperation("(成长值变化历史记录)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long growthChangeHistoryId) {
        GrowthChangeHistory growthChangeHistory = growthChangeHistoryService.getById(growthChangeHistoryId);
        return ResponseEntity.ok("data", growthChangeHistory);
    }

    /**
     * (成长值变化历史记录)批量新增或修改
     *
     * @param growthChangeHistorys 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(成长值变化历史记录)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<GrowthChangeHistory> growthChangeHistorys) {
        boolean flag = growthChangeHistoryService.saveOrUpdateBatch(growthChangeHistorys);
        return flag ? ResponseEntity.ok("(成长值变化历史记录)批量变更成功") : ResponseEntity.error("(成长值变化历史记录)批量变更失败");
    }

    /**
     * (成长值变化历史记录)新增
     *
     * @param growthChangeHistory (成长值变化历史记录)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(成长值变化历史记录)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody GrowthChangeHistory growthChangeHistory) {
        boolean flag = growthChangeHistoryService.saveOrUpdate(growthChangeHistory);
        return flag ? ResponseEntity.ok("(成长值变化历史记录)新增成功") : ResponseEntity.error("(成长值变化历史记录)新增失败");
    }

    /**
     * (成长值变化历史记录)更新
     *
     * @param growthChangeHistory (成长值变化历史记录)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(成长值变化历史记录)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody GrowthChangeHistory growthChangeHistory) {
        boolean flag = growthChangeHistoryService.updateById(growthChangeHistory);
        return flag ? ResponseEntity.ok("(成长值变化历史记录)更新成功") : ResponseEntity.error("(成长值变化历史记录)更新失败");
    }

    /**
     * 批量更新(成长值变化历史记录)
     *
     * @param growthChangeHistorys (成长值变化历史记录)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(成长值变化历史记录)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<GrowthChangeHistory> growthChangeHistorys) {
        boolean flag = growthChangeHistoryService.updateBatchById(growthChangeHistorys);
        return flag ? ResponseEntity.ok("批量更新(成长值变化历史记录)成功") : ResponseEntity.error("批量更新(成长值变化历史记录)失败");
    }

    /**
     * (成长值变化历史记录)删除
     *
     * @param deleteIds 删除(成长值变化历史记录)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(成长值变化历史记录)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = growthChangeHistoryService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(成长值变化历史记录)删除成功") : ResponseEntity.error("(成长值变化历史记录)删除失败");
    }
}