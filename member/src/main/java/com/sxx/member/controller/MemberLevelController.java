package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberLevel;
import com.sxx.member.service.MemberLevelService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_member_level(会员等级)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-10 23:30:48
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员等级)")
@RequestMapping("member/memberLevel")
public class MemberLevelController {

    private final MemberLevelService levelService;

    /**
     * 查询会员等级列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("会员等级列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return levelService.queryPage(params);
    }

    /**
     * 等级详细信息
     *
     * @param memberLevelId 等级id
     * @return 详情信息
     */
    @ApiOperation("等级详情")
    @GetMapping("info/{memberLevelId}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity info(@PathVariable Long memberLevelId) {
        MemberLevel memberLevel = levelService.getById(memberLevelId);
        return ResponseEntity.ok("data", memberLevel);
    }

    /**
     * 会员等级新增或修改
     *
     * @param memberLevels 修改集合
     * @return 修改状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("会员等级新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberLevel> memberLevels) {
        boolean flag = levelService.saveOrUpdateBatch(memberLevels);
        return flag ? ResponseEntity.ok("会员等级变更成功") : ResponseEntity.error("会员等级变更失败");
    }

    /**
     * 会员等级新增
     *
     * @param memberLevel 等级信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("会员新增等级")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberLevel memberLevel) {
        boolean flag = levelService.saveOrUpdate(memberLevel);
        return flag ? ResponseEntity.ok("会员等级新增成功") : ResponseEntity.error("会员等级新增失败");
    }

    /**
     * 会员等级更新
     *
     * @param memberLevel 更新信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("会员等级更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberLevel memberLevel) {
        boolean flag = levelService.updateById(memberLevel);
        return flag ? ResponseEntity.ok("会员等级更新成功") : ResponseEntity.error("会员等级更新失败");
    }

    /**
     * 批量更新会员等级
     *
     * @param memberLevels 会员等级信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新会员等级")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberLevel> memberLevels) {
        boolean flag = levelService.updateBatchById(memberLevels);
        return flag ? ResponseEntity.ok("批量更新会员等级成功") : ResponseEntity.error("批量更新会员等级失败");
    }

    /**
     * 会员等级删除
     *
     * @param deleteIds 删除集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("会员等级删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = levelService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("会员等级删除成功") : ResponseEntity.error("会员等级删除失败");
    }
}
