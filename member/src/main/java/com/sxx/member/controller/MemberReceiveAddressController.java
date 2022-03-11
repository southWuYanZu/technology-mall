package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberReceiveAddress;
import com.sxx.member.service.MemberReceiveAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_member_receive_address(会员收货地址)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员收货地址)")
@RequestMapping("MemberReceiveAddress")
public class MemberReceiveAddressController {

    private final MemberReceiveAddressService memberReceiveAddressService;

    /**
     * 查询(会员收货地址)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(会员收货地址)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberReceiveAddressService.queryPage(params);
    }

    /**
     * (会员收货地址)详细信息
     *
     * @param memberReceiveAddressId (会员收货地址)Id
     * @return (会员收货地址)详情信息
     */
    @GetMapping("info/{memberReceiveAddressId}")
    @ApiOperation("(会员收货地址)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long memberReceiveAddressId) {
        MemberReceiveAddress memberReceiveAddress = memberReceiveAddressService.getById(memberReceiveAddressId);
        return ResponseEntity.ok("data", memberReceiveAddress);
    }

    /**
     * (会员收货地址)批量新增或修改
     *
     * @param memberReceiveAddresss 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(会员收货地址)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberReceiveAddress> memberReceiveAddresss) {
        boolean flag = memberReceiveAddressService.saveOrUpdateBatch(memberReceiveAddresss);
        return flag ? ResponseEntity.ok("(会员收货地址)批量变更成功") : ResponseEntity.error("(会员收货地址)批量变更失败");
    }

    /**
     * (会员收货地址)新增
     *
     * @param memberReceiveAddress (会员收货地址)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(会员收货地址)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberReceiveAddress memberReceiveAddress) {
        boolean flag = memberReceiveAddressService.saveOrUpdate(memberReceiveAddress);
        return flag ? ResponseEntity.ok("(会员收货地址)新增成功") : ResponseEntity.error("(会员收货地址)新增失败");
    }

    /**
     * (会员收货地址)更新
     *
     * @param memberReceiveAddress (会员收货地址)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(会员收货地址)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberReceiveAddress memberReceiveAddress) {
        boolean flag = memberReceiveAddressService.updateById(memberReceiveAddress);
        return flag ? ResponseEntity.ok("(会员收货地址)更新成功") : ResponseEntity.error("(会员收货地址)更新失败");
    }

    /**
     * 批量更新(会员收货地址)
     *
     * @param memberReceiveAddresss (会员收货地址)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(会员收货地址)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberReceiveAddress> memberReceiveAddresss) {
        boolean flag = memberReceiveAddressService.updateBatchById(memberReceiveAddresss);
        return flag ? ResponseEntity.ok("批量更新(会员收货地址)成功") : ResponseEntity.error("批量更新(会员收货地址)失败");
    }

    /**
     * (会员收货地址)删除
     *
     * @param deleteIds 删除(会员收货地址)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(会员收货地址)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = memberReceiveAddressService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(会员收货地址)删除成功") : ResponseEntity.error("(会员收货地址)删除失败");
    }
}