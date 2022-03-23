package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.SpuBounds;
import com.sxx.coupon.service.SpuBoundsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_spu_bounds(商品spu积分设置)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(商品spu积分设置)")
@RequestMapping("coupon/spuBounds")
public class SpuBoundsController {

    private final SpuBoundsService spuBoundsService;

    /**
     * 查询(商品spu积分设置)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(商品spu积分设置)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return spuBoundsService.queryPage(params);
    }

    /**
     * (商品spu积分设置)详细信息
     *
     * @param spuBoundsId (商品spu积分设置)Id
     * @return (商品spu积分设置)详情信息
     */
    @GetMapping("info/{spuBoundsId}")
    @ApiOperation("(商品spu积分设置)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long spuBoundsId) {
        SpuBounds spuBounds = spuBoundsService.getById(spuBoundsId);
        return ResponseEntity.ok("data", spuBounds);
    }

    /**
     * (商品spu积分设置)批量新增或修改
     *
     * @param spuBounds 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(商品spu积分设置)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<SpuBounds> spuBounds) {
        boolean flag = spuBoundsService.saveOrUpdateBatch(spuBounds);
        return flag ? ResponseEntity.ok("(商品spu积分设置)批量变更成功") : ResponseEntity.error("(商品spu积分设置)批量变更失败");
    }

    /**
     * (商品spu积分设置)新增
     *
     * @param spuBounds (商品spu积分设置)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(商品spu积分设置)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody SpuBounds spuBounds) {
        boolean flag = spuBoundsService.saveOrUpdate(spuBounds);
        return flag ? ResponseEntity.ok("(商品spu积分设置)新增成功") : ResponseEntity.error("(商品spu积分设置)新增失败");
    }

    /**
     * (商品spu积分设置)更新
     *
     * @param spuBounds (商品spu积分设置)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(商品spu积分设置)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody SpuBounds spuBounds) {
        boolean flag = spuBoundsService.updateById(spuBounds);
        return flag ? ResponseEntity.ok("(商品spu积分设置)更新成功") : ResponseEntity.error("(商品spu积分设置)更新失败");
    }

    /**
     * 批量更新(商品spu积分设置)
     *
     * @param spuBounds (商品spu积分设置)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(商品spu积分设置)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<SpuBounds> spuBounds) {
        boolean flag = spuBoundsService.updateBatchById(spuBounds);
        return flag ? ResponseEntity.ok("批量更新(商品spu积分设置)成功") : ResponseEntity.error("批量更新(商品spu积分设置)失败");
    }

    /**
     * (商品spu积分设置)删除
     *
     * @param deleteIds 删除(商品spu积分设置)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(商品spu积分设置)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = spuBoundsService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(商品spu积分设置)删除成功") : ResponseEntity.error("(商品spu积分设置)删除失败");
    }
}