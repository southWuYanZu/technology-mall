package com.sxx.coupon.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_coupon_spu_relation(优惠券与产品关联)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(优惠券与产品关联)")
@RequestMapping("couponSpuRelation")
public class CouponSpuRelationController {

    private final CouponSpuRelationService couponSpuRelationService;

    /**
     * 查询(优惠券与产品关联)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(优惠券与产品关联)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return couponSpuRelationService.queryPage(params);
    }

    /**
     * (优惠券与产品关联)详细信息
     *
     * @param couponSpuRelationId (优惠券与产品关联)Id
     * @return (优惠券与产品关联)详情信息
     */
    @GetMapping("info/{couponSpuRelationId}")
    @ApiOperation("(优惠券与产品关联)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long couponSpuRelationId) {
        CouponSpuRelation couponSpuRelation = couponSpuRelationService.getById(couponSpuRelationId);
        return ResponseEntity.ok("data", couponSpuRelation);
    }

    /**
     * (优惠券与产品关联)批量新增或修改
     *
     * @param couponSpuRelations 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(优惠券与产品关联)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<CouponSpuRelation> couponSpuRelations) {
        boolean flag = couponSpuRelationService.saveOrUpdateBatch(couponSpuRelations);
        return flag ? ResponseEntity.ok("(优惠券与产品关联)批量变更成功") : ResponseEntity.error("(优惠券与产品关联)批量变更失败");
    }

    /**
     * (优惠券与产品关联)新增
     *
     * @param couponSpuRelation (优惠券与产品关联)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(优惠券与产品关联)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody CouponSpuRelation couponSpuRelation) {
        boolean flag = couponSpuRelationService.saveOrUpdate(couponSpuRelation);
        return flag ? ResponseEntity.ok("(优惠券与产品关联)新增成功") : ResponseEntity.error("(优惠券与产品关联)新增失败");
    }

    /**
     * (优惠券与产品关联)更新
     *
     * @param couponSpuRelation (优惠券与产品关联)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(优惠券与产品关联)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody CouponSpuRelation couponSpuRelation) {
        boolean flag = couponSpuRelationService.updateById(couponSpuRelation);
        return flag ? ResponseEntity.ok("(优惠券与产品关联)更新成功") : ResponseEntity.error("(优惠券与产品关联)更新失败");
    }

    /**
     * 批量更新(优惠券与产品关联)
     *
     * @param couponSpuRelations (优惠券与产品关联)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(优惠券与产品关联)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<CouponSpuRelation> couponSpuRelations) {
        boolean flag = couponSpuRelationService.updateBatchById(couponSpuRelations);
        return flag ? ResponseEntity.ok("批量更新(优惠券与产品关联)成功") : ResponseEntity.error("批量更新(优惠券与产品关联)失败");
    }

    /**
     * (优惠券与产品关联)删除
     *
     * @param deleteIds 删除(优惠券与产品关联)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(优惠券与产品关联)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = couponSpuRelationService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(优惠券与产品关联)删除成功") : ResponseEntity.error("(优惠券与产品关联)删除失败");
    }
}