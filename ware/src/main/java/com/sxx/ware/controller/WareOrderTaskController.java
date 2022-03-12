package com.sxx.ware.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareOrderTask;
import com.sxx.ware.service.WareOrderTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【wms_ware_order_task(库存工作单)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(库存工作单)")
@RequestMapping("WareOrderTask")
public class WareOrderTaskController {

    private final WareOrderTaskService wareOrderTaskService;

    /**
     * 查询(库存工作单)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(库存工作单)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return wareOrderTaskService.queryPage(params);
    }

    /**
     * (库存工作单)详细信息
     *
     * @param wareOrderTaskId (库存工作单)Id
     * @return (库存工作单)详情信息
     */
    @GetMapping("info/{wareOrderTaskId}")
    @ApiOperation("(库存工作单)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long wareOrderTaskId) {
        WareOrderTask wareOrderTask = wareOrderTaskService.getById(wareOrderTaskId);
        return ResponseEntity.ok("data", wareOrderTask);
    }

    /**
     * (库存工作单)批量新增或修改
     *
     * @param wareOrderTasks 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(库存工作单)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<WareOrderTask> wareOrderTasks) {
        boolean flag = wareOrderTaskService.saveOrUpdateBatch(wareOrderTasks);
        return flag ? ResponseEntity.ok("(库存工作单)批量变更成功") : ResponseEntity.error("(库存工作单)批量变更失败");
    }

    /**
     * (库存工作单)新增
     *
     * @param wareOrderTask (库存工作单)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(库存工作单)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody WareOrderTask wareOrderTask) {
        boolean flag = wareOrderTaskService.saveOrUpdate(wareOrderTask);
        return flag ? ResponseEntity.ok("(库存工作单)新增成功") : ResponseEntity.error("(库存工作单)新增失败");
    }

    /**
     * (库存工作单)更新
     *
     * @param wareOrderTask (库存工作单)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(库存工作单)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody WareOrderTask wareOrderTask) {
        boolean flag = wareOrderTaskService.updateById(wareOrderTask);
        return flag ? ResponseEntity.ok("(库存工作单)更新成功") : ResponseEntity.error("(库存工作单)更新失败");
    }

    /**
     * 批量更新(库存工作单)
     *
     * @param wareOrderTasks (库存工作单)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(库存工作单)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<WareOrderTask> wareOrderTasks) {
        boolean flag = wareOrderTaskService.updateBatchById(wareOrderTasks);
        return flag ? ResponseEntity.ok("批量更新(库存工作单)成功") : ResponseEntity.error("批量更新(库存工作单)失败");
    }

    /**
     * (库存工作单)删除
     *
     * @param deleteIds 删除(库存工作单)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(库存工作单)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = wareOrderTaskService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(库存工作单)删除成功") : ResponseEntity.error("(库存工作单)删除失败");
    }
}