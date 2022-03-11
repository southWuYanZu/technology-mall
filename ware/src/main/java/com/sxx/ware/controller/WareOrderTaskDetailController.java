package com.sxx.ware.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【wms_ware_order_task_detail(库存工作单)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(库存工作单)")
@RequestMapping("WareOrderTaskDetail")
public class WareOrderTaskDetailController {

    private final WareOrderTaskDetailService wareOrderTaskDetailService;

    /**
     * 查询(库存工作单)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(库存工作单)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return wareOrderTaskDetailService.queryPage(params);
    }

    /**
     * (库存工作单)详细信息
     *
     * @param wareOrderTaskDetailId (库存工作单)Id
     * @return (库存工作单)详情信息
     */
    @GetMapping("info/{wareOrderTaskDetailId}")
    @ApiOperation("(库存工作单)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long wareOrderTaskDetailId) {
        WareOrderTaskDetail wareOrderTaskDetail = wareOrderTaskDetailService.getById(wareOrderTaskDetailId);
        return ResponseEntity.ok("data", wareOrderTaskDetail);
    }

    /**
     * (库存工作单)批量新增或修改
     *
     * @param wareOrderTaskDetails 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(库存工作单)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<WareOrderTaskDetail> wareOrderTaskDetails) {
        boolean flag = wareOrderTaskDetailService.saveOrUpdateBatch(wareOrderTaskDetails);
        return flag ? ResponseEntity.ok("(库存工作单)批量变更成功") : ResponseEntity.error("(库存工作单)批量变更失败");
    }

    /**
     * (库存工作单)新增
     *
     * @param wareOrderTaskDetail (库存工作单)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(库存工作单)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
        boolean flag = wareOrderTaskDetailService.saveOrUpdate(wareOrderTaskDetail);
        return flag ? ResponseEntity.ok("(库存工作单)新增成功") : ResponseEntity.error("(库存工作单)新增失败");
    }

    /**
     * (库存工作单)更新
     *
     * @param wareOrderTaskDetail (库存工作单)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(库存工作单)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
        boolean flag = wareOrderTaskDetailService.updateById(wareOrderTaskDetail);
        return flag ? ResponseEntity.ok("(库存工作单)更新成功") : ResponseEntity.error("(库存工作单)更新失败");
    }

    /**
     * 批量更新(库存工作单)
     *
     * @param wareOrderTaskDetails (库存工作单)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(库存工作单)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<WareOrderTaskDetail> wareOrderTaskDetails) {
        boolean flag = wareOrderTaskDetailService.updateBatchById(wareOrderTaskDetails);
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
        boolean flag = wareOrderTaskDetailService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(库存工作单)删除成功") : ResponseEntity.error("(库存工作单)删除失败");
    }
}