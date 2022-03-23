package com.sxx.coupon.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_coupon_history(优惠券领取历史记录)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(优惠券领取历史记录)")
@RequestMapping("couponHistory")
public class CouponHistoryController {

    private final CouponHistoryService couponHistoryService;

    /**
     * 查询(优惠券领取历史记录)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(优惠券领取历史记录)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return couponHistoryService.queryPage(params);
    }

    /**
     * (优惠券领取历史记录)详细信息
     *
     * @param couponHistoryId (优惠券领取历史记录)Id
     * @return (优惠券领取历史记录)详情信息
     */
    @GetMapping("info/{couponHistoryId}")
    @ApiOperation("(优惠券领取历史记录)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long couponHistoryId) {
        CouponHistory couponHistory = couponHistoryService.getById(couponHistoryId);
        return ResponseEntity.ok("data", couponHistory);
    }

    /**
     * (优惠券领取历史记录)批量新增或修改
     *
     * @param couponHistorys 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(优惠券领取历史记录)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<CouponHistory> couponHistorys) {
        boolean flag = couponHistoryService.saveOrUpdateBatch(couponHistorys);
        return flag ? ResponseEntity.ok("(优惠券领取历史记录)批量变更成功") : ResponseEntity.error("(优惠券领取历史记录)批量变更失败");
    }

    /**
     * (优惠券领取历史记录)新增
     *
     * @param couponHistory (优惠券领取历史记录)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(优惠券领取历史记录)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody CouponHistory couponHistory) {
        boolean flag = couponHistoryService.saveOrUpdate(couponHistory);
        return flag ? ResponseEntity.ok("(优惠券领取历史记录)新增成功") : ResponseEntity.error("(优惠券领取历史记录)新增失败");
    }

    /**
     * (优惠券领取历史记录)更新
     *
     * @param couponHistory (优惠券领取历史记录)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(优惠券领取历史记录)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody CouponHistory couponHistory) {
        boolean flag = couponHistoryService.updateById(couponHistory);
        return flag ? ResponseEntity.ok("(优惠券领取历史记录)更新成功") : ResponseEntity.error("(优惠券领取历史记录)更新失败");
    }

    /**
     * 批量更新(优惠券领取历史记录)
     *
     * @param couponHistorys (优惠券领取历史记录)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(优惠券领取历史记录)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<CouponHistory> couponHistorys) {
        boolean flag = couponHistoryService.updateBatchById(couponHistorys);
        return flag ? ResponseEntity.ok("批量更新(优惠券领取历史记录)成功") : ResponseEntity.error("批量更新(优惠券领取历史记录)失败");
    }

    /**
     * (优惠券领取历史记录)删除
     *
     * @param deleteIds 删除(优惠券领取历史记录)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(优惠券领取历史记录)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = couponHistoryService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(优惠券领取历史记录)删除成功") : ResponseEntity.error("(优惠券领取历史记录)删除失败");
    }
}