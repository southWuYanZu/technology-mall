package com.sxx.member.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_member_login_log(会员登录记录)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员登录记录)")
@RequestMapping("MemberLoginLog")
public class MemberLoginLogController {

    private final MemberLoginLogService memberLoginLogService;

    /**
     * 查询(会员登录记录)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(会员登录记录)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberLoginLogService.queryPage(params);
    }

    /**
     * (会员登录记录)详细信息
     *
     * @param memberLoginLogId (会员登录记录)Id
     * @return (会员登录记录)详情信息
     */
    @GetMapping("info/{memberLoginLogId}")
    @ApiOperation("(会员登录记录)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long memberLoginLogId) {
        MemberLoginLog memberLoginLog = memberLoginLogService.getById(memberLoginLogId);
        return ResponseEntity.ok("data", memberLoginLog);
    }

    /**
     * (会员登录记录)批量新增或修改
     *
     * @param memberLoginLogs 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(会员登录记录)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberLoginLog> memberLoginLogs) {
        boolean flag = memberLoginLogService.saveOrUpdateBatch(memberLoginLogs);
        return flag ? ResponseEntity.ok("(会员登录记录)批量变更成功") : ResponseEntity.error("(会员登录记录)批量变更失败");
    }

    /**
     * (会员登录记录)新增
     *
     * @param memberLoginLog (会员登录记录)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(会员登录记录)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberLoginLog memberLoginLog) {
        boolean flag = memberLoginLogService.saveOrUpdate(memberLoginLog);
        return flag ? ResponseEntity.ok("(会员登录记录)新增成功") : ResponseEntity.error("(会员登录记录)新增失败");
    }

    /**
     * (会员登录记录)更新
     *
     * @param memberLoginLog (会员登录记录)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(会员登录记录)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberLoginLog memberLoginLog) {
        boolean flag = memberLoginLogService.updateById(memberLoginLog);
        return flag ? ResponseEntity.ok("(会员登录记录)更新成功") : ResponseEntity.error("(会员登录记录)更新失败");
    }

    /**
     * 批量更新(会员登录记录)
     *
     * @param memberLoginLogs (会员登录记录)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(会员登录记录)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberLoginLog> memberLoginLogs) {
        boolean flag = memberLoginLogService.updateBatchById(memberLoginLogs);
        return flag ? ResponseEntity.ok("批量更新(会员登录记录)成功") : ResponseEntity.error("批量更新(会员登录记录)失败");
    }

    /**
     * (会员登录记录)删除
     *
     * @param deleteIds 删除(会员登录记录)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(会员登录记录)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = memberLoginLogService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(会员登录记录)删除成功") : ResponseEntity.error("(会员登录记录)删除失败");
    }
}