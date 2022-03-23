package com.sxx.coupon.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_member_price(商品会员价格)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(商品会员价格)")
@RequestMapping("memberPrice")
public class MemberPriceController {

    private final MemberPriceService memberPriceService;

    /**
     * 查询(商品会员价格)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(商品会员价格)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberPriceService.queryPage(params);
    }

    /**
     * (商品会员价格)详细信息
     *
     * @param memberPriceId (商品会员价格)Id
     * @return (商品会员价格)详情信息
     */
    @GetMapping("info/{memberPriceId}")
    @ApiOperation("(商品会员价格)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long memberPriceId) {
        MemberPrice memberPrice = memberPriceService.getById(memberPriceId);
        return ResponseEntity.ok("data", memberPrice);
    }

    /**
     * (商品会员价格)批量新增或修改
     *
     * @param memberPrices 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(商品会员价格)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberPrice> memberPrices) {
        boolean flag = memberPriceService.saveOrUpdateBatch(memberPrices);
        return flag ? ResponseEntity.ok("(商品会员价格)批量变更成功") : ResponseEntity.error("(商品会员价格)批量变更失败");
    }

    /**
     * (商品会员价格)新增
     *
     * @param memberPrice (商品会员价格)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(商品会员价格)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberPrice memberPrice) {
        boolean flag = memberPriceService.saveOrUpdate(memberPrice);
        return flag ? ResponseEntity.ok("(商品会员价格)新增成功") : ResponseEntity.error("(商品会员价格)新增失败");
    }

    /**
     * (商品会员价格)更新
     *
     * @param memberPrice (商品会员价格)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(商品会员价格)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberPrice memberPrice) {
        boolean flag = memberPriceService.updateById(memberPrice);
        return flag ? ResponseEntity.ok("(商品会员价格)更新成功") : ResponseEntity.error("(商品会员价格)更新失败");
    }

    /**
     * 批量更新(商品会员价格)
     *
     * @param memberPrices (商品会员价格)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(商品会员价格)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberPrice> memberPrices) {
        boolean flag = memberPriceService.updateBatchById(memberPrices);
        return flag ? ResponseEntity.ok("批量更新(商品会员价格)成功") : ResponseEntity.error("批量更新(商品会员价格)失败");
    }

    /**
     * (商品会员价格)删除
     *
     * @param deleteIds 删除(商品会员价格)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(商品会员价格)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = memberPriceService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(商品会员价格)删除成功") : ResponseEntity.error("(商品会员价格)删除失败");
    }
}