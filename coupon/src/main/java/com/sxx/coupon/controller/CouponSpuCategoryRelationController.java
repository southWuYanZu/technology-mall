package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.CouponSpuCategoryRelation;
import com.sxx.coupon.service.CouponSpuCategoryRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_coupon_spu_category_relation(优惠券分类关联)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:41
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(优惠券分类关联)")
@RequestMapping("couponSpuCategoryRelation")
public class CouponSpuCategoryRelationController {

    private final CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    /**
     * 查询(优惠券分类关联)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(优惠券分类关联)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return couponSpuCategoryRelationService.queryPage(params);
    }

    /**
     * (优惠券分类关联)详细信息
     *
     * @param couponSpuCategoryRelationId (优惠券分类关联)Id
     * @return (优惠券分类关联)详情信息
     */
    @GetMapping("info/{couponSpuCategoryRelationId}")
    @ApiOperation("(优惠券分类关联)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long couponSpuCategoryRelationId) {
        CouponSpuCategoryRelation couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(couponSpuCategoryRelationId);
        return ResponseEntity.ok("data", couponSpuCategoryRelation);
    }

    /**
     * (优惠券分类关联)批量新增或修改
     *
     * @param couponSpuCategoryRelations 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(优惠券分类关联)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<CouponSpuCategoryRelation> couponSpuCategoryRelations) {
        boolean flag = couponSpuCategoryRelationService.saveOrUpdateBatch(couponSpuCategoryRelations);
        return flag ? ResponseEntity.ok("(优惠券分类关联)批量变更成功") : ResponseEntity.error("(优惠券分类关联)批量变更失败");
    }

    /**
     * (优惠券分类关联)新增
     *
     * @param couponSpuCategoryRelation (优惠券分类关联)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(优惠券分类关联)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation) {
        boolean flag = couponSpuCategoryRelationService.saveOrUpdate(couponSpuCategoryRelation);
        return flag ? ResponseEntity.ok("(优惠券分类关联)新增成功") : ResponseEntity.error("(优惠券分类关联)新增失败");
    }

    /**
     * (优惠券分类关联)更新
     *
     * @param couponSpuCategoryRelation (优惠券分类关联)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(优惠券分类关联)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation) {
        boolean flag = couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation);
        return flag ? ResponseEntity.ok("(优惠券分类关联)更新成功") : ResponseEntity.error("(优惠券分类关联)更新失败");
    }

    /**
     * 批量更新(优惠券分类关联)
     *
     * @param couponSpuCategoryRelations (优惠券分类关联)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(优惠券分类关联)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<CouponSpuCategoryRelation> couponSpuCategoryRelations) {
        boolean flag = couponSpuCategoryRelationService.updateBatchById(couponSpuCategoryRelations);
        return flag ? ResponseEntity.ok("批量更新(优惠券分类关联)成功") : ResponseEntity.error("批量更新(优惠券分类关联)失败");
    }

    /**
     * (优惠券分类关联)删除
     *
     * @param deleteIds 删除(优惠券分类关联)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(优惠券分类关联)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = couponSpuCategoryRelationService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(优惠券分类关联)删除成功") : ResponseEntity.error("(优惠券分类关联)删除失败");
    }
}