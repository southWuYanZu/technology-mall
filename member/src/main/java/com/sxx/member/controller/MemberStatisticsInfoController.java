package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberStatisticsInfo;
import com.sxx.member.service.MemberStatisticsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_member_statistics_info(会员统计信息)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员统计信息)")
@RequestMapping("MemberStatisticsInfo")
public class MemberStatisticsInfoController {

    private final MemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 查询(会员统计信息)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(会员统计信息)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberStatisticsInfoService.queryPage(params);
    }

    /**
     * (会员统计信息)详细信息
     *
     * @param memberStatisticsInfoId (会员统计信息)Id
     * @return (会员统计信息)详情信息
     */
    @GetMapping("info/{memberStatisticsInfoId}")
    @ApiOperation("(会员统计信息)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long memberStatisticsInfoId) {
        MemberStatisticsInfo memberStatisticsInfo = memberStatisticsInfoService.getById(memberStatisticsInfoId);
        return ResponseEntity.ok("data", memberStatisticsInfo);
    }

    /**
     * (会员统计信息)批量新增或修改
     *
     * @param memberStatisticsInfos 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(会员统计信息)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberStatisticsInfo> memberStatisticsInfos) {
        boolean flag = memberStatisticsInfoService.saveOrUpdateBatch(memberStatisticsInfos);
        return flag ? ResponseEntity.ok("(会员统计信息)批量变更成功") : ResponseEntity.error("(会员统计信息)批量变更失败");
    }

    /**
     * (会员统计信息)新增
     *
     * @param memberStatisticsInfo (会员统计信息)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(会员统计信息)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
        boolean flag = memberStatisticsInfoService.saveOrUpdate(memberStatisticsInfo);
        return flag ? ResponseEntity.ok("(会员统计信息)新增成功") : ResponseEntity.error("(会员统计信息)新增失败");
    }

    /**
     * (会员统计信息)更新
     *
     * @param memberStatisticsInfo (会员统计信息)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(会员统计信息)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
        boolean flag = memberStatisticsInfoService.updateById(memberStatisticsInfo);
        return flag ? ResponseEntity.ok("(会员统计信息)更新成功") : ResponseEntity.error("(会员统计信息)更新失败");
    }

    /**
     * 批量更新(会员统计信息)
     *
     * @param memberStatisticsInfos (会员统计信息)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(会员统计信息)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberStatisticsInfo> memberStatisticsInfos) {
        boolean flag = memberStatisticsInfoService.updateBatchById(memberStatisticsInfos);
        return flag ? ResponseEntity.ok("批量更新(会员统计信息)成功") : ResponseEntity.error("批量更新(会员统计信息)失败");
    }

    /**
     * (会员统计信息)删除
     *
     * @param deleteIds 删除(会员统计信息)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(会员统计信息)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = memberStatisticsInfoService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(会员统计信息)删除成功") : ResponseEntity.error("(会员统计信息)删除失败");
    }
}