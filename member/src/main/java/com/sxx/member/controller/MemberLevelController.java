package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberLevel;
import com.sxx.member.service.MemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_member_level(会员等级)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员等级)")
@RequestMapping("member/memberLevel")
public class MemberLevelController {

    private final MemberLevelService memberLevelService;

    /**
     * 查询(会员等级)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(会员等级)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberLevelService.queryPage(params);
    }

    /**
     * (会员等级)详细信息
     *
     * @param memberLevelId (会员等级)Id
     * @return (会员等级)详情信息
     */
    @GetMapping("info/{memberLevelId}")
    @ApiOperation("(会员等级)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long memberLevelId) {
        MemberLevel memberLevel = memberLevelService.getById(memberLevelId);
        return ResponseEntity.ok("data", memberLevel);
    }

    /**
     * (会员等级)批量新增或修改
     *
     * @param memberLevels 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(会员等级)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberLevel> memberLevels) {
        boolean flag = memberLevelService.saveOrUpdateBatch(memberLevels);
        return flag ? ResponseEntity.ok("(会员等级)批量变更成功") : ResponseEntity.error("(会员等级)批量变更失败");
    }

    /**
     * (会员等级)新增
     *
     * @param memberLevel (会员等级)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(会员等级)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberLevel memberLevel) {
        boolean flag = memberLevelService.saveOrUpdate(memberLevel);
        return flag ? ResponseEntity.ok("(会员等级)新增成功") : ResponseEntity.error("(会员等级)新增失败");
    }

    /**
     * (会员等级)更新
     *
     * @param memberLevel (会员等级)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(会员等级)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberLevel memberLevel) {
        boolean flag = memberLevelService.updateById(memberLevel);
        return flag ? ResponseEntity.ok("(会员等级)更新成功") : ResponseEntity.error("(会员等级)更新失败");
    }

    /**
     * 批量更新(会员等级)
     *
     * @param memberLevels (会员等级)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(会员等级)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberLevel> memberLevels) {
        boolean flag = memberLevelService.updateBatchById(memberLevels);
        return flag ? ResponseEntity.ok("批量更新(会员等级)成功") : ResponseEntity.error("批量更新(会员等级)失败");
    }

    /**
     * (会员等级)删除
     *
     * @param deleteIds 删除(会员等级)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(会员等级)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = memberLevelService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(会员等级)删除成功") : ResponseEntity.error("(会员等级)删除失败");
    }
}