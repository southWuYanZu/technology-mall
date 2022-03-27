package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.Coupon;
import com.sxx.coupon.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_coupon(优惠券信息)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(优惠券信息)")
@RequestMapping("coupon")
public class CouponController {

    private final CouponService couponService;

    /**
     * 查询(优惠券信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(优惠券信息)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return couponService.queryPage(params);
    }

    /**
     * (优惠券信息)详细信息
     *
     * @param couponId (优惠券信息)Id
     * @return (优惠券信息)详情信息
     */
    @GetMapping("info/{couponId}")
    @ApiOperation("(优惠券信息)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long couponId) {
        Coupon coupon = couponService.getById(couponId);
        return ResponseEntity.ok("data", coupon);
    }

    /**
     * (优惠券信息)批量新增或修改
     *
     * @param coupons 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(优惠券信息)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<Coupon> coupons) {
        boolean flag = couponService.saveOrUpdateBatch(coupons);
        return flag ? ResponseEntity.ok("(优惠券信息)批量变更成功") : ResponseEntity.error("(优惠券信息)批量变更失败");
    }

    /**
     * (优惠券信息)新增
     *
     * @param coupon (优惠券信息)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(优惠券信息)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody Coupon coupon) {
        boolean flag = couponService.saveOrUpdate(coupon);
        return flag ? ResponseEntity.ok("(优惠券信息)新增成功") : ResponseEntity.error("(优惠券信息)新增失败");
    }

    /**
     * (优惠券信息)更新
     *
     * @param coupon (优惠券信息)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(优惠券信息)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody Coupon coupon) {
        boolean flag = couponService.updateById(coupon);
        return flag ? ResponseEntity.ok("(优惠券信息)更新成功") : ResponseEntity.error("(优惠券信息)更新失败");
    }

    /**
     * 批量更新(优惠券信息)
     *
     * @param coupons (优惠券信息)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(优惠券信息)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<Coupon> coupons) {
        boolean flag = couponService.updateBatchById(coupons);
        return flag ? ResponseEntity.ok("批量更新(优惠券信息)成功") : ResponseEntity.error("批量更新(优惠券信息)失败");
    }

    /**
     * (优惠券信息)删除
     *
     * @param deleteIds 删除(优惠券信息)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(优惠券信息)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = couponService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(优惠券信息)删除成功") : ResponseEntity.error("(优惠券信息)删除失败");
    }
}