package com.sxx.ware.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.WareInfo;
import com.sxx.ware.service.WareInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【wms_ware_info(仓库信息)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 16:05:17
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(仓库信息)")
@RequestMapping("WareInfo")
public class WareInfoController {

    private final WareInfoService wareInfoService;

    /**
     * 查询(仓库信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(仓库信息)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return wareInfoService.queryPage(params);
    }

    /**
     * (仓库信息)详细信息
     *
     * @param wareInfoId (仓库信息)Id
     * @return (仓库信息)详情信息
     */
    @GetMapping("info/{wareInfoId}")
    @ApiOperation("(仓库信息)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long wareInfoId) {
        WareInfo wareInfo = wareInfoService.getById(wareInfoId);
        return ResponseEntity.ok("data", wareInfo);
    }

    /**
     * (仓库信息)批量新增或修改
     *
     * @param wareInfos 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(仓库信息)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<WareInfo> wareInfos) {
        boolean flag = wareInfoService.saveOrUpdateBatch(wareInfos);
        return flag ? ResponseEntity.ok("(仓库信息)批量变更成功") : ResponseEntity.error("(仓库信息)批量变更失败");
    }

    /**
     * (仓库信息)新增
     *
     * @param wareInfo (仓库信息)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(仓库信息)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody WareInfo wareInfo) {
        boolean flag = wareInfoService.saveOrUpdate(wareInfo);
        return flag ? ResponseEntity.ok("(仓库信息)新增成功") : ResponseEntity.error("(仓库信息)新增失败");
    }

    /**
     * (仓库信息)更新
     *
     * @param wareInfo (仓库信息)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(仓库信息)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody WareInfo wareInfo) {
        boolean flag = wareInfoService.updateById(wareInfo);
        return flag ? ResponseEntity.ok("(仓库信息)更新成功") : ResponseEntity.error("(仓库信息)更新失败");
    }

    /**
     * 批量更新(仓库信息)
     *
     * @param wareInfos (仓库信息)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(仓库信息)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<WareInfo> wareInfos) {
        boolean flag = wareInfoService.updateBatchById(wareInfos);
        return flag ? ResponseEntity.ok("批量更新(仓库信息)成功") : ResponseEntity.error("批量更新(仓库信息)失败");
    }

    /**
     * (仓库信息)删除
     *
     * @param deleteIds 删除(仓库信息)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(仓库信息)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = wareInfoService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(仓库信息)删除成功") : ResponseEntity.error("(仓库信息)删除失败");
    }
}