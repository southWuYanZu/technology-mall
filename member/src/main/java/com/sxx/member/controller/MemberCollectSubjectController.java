package com.sxx.member.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_member_collect_subject(会员收藏的专题活动)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员收藏的专题活动)")
@RequestMapping("MemberCollectSubject")
public class MemberCollectSubjectController {

    private final MemberCollectSubjectService memberCollectSubjectService;

    /**
     * 查询(会员收藏的专题活动)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(会员收藏的专题活动)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberCollectSubjectService.queryPage(params);
    }

    /**
     * (会员收藏的专题活动)详细信息
     *
     * @param memberCollectSubjectId (会员收藏的专题活动)Id
     * @return (会员收藏的专题活动)详情信息
     */
    @GetMapping("info/{memberCollectSubjectId}")
    @ApiOperation("(会员收藏的专题活动)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long memberCollectSubjectId) {
        MemberCollectSubject memberCollectSubject = memberCollectSubjectService.getById(memberCollectSubjectId);
        return ResponseEntity.ok("data", memberCollectSubject);
    }

    /**
     * (会员收藏的专题活动)批量新增或修改
     *
     * @param memberCollectSubjects 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(会员收藏的专题活动)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberCollectSubject> memberCollectSubjects) {
        boolean flag = memberCollectSubjectService.saveOrUpdateBatch(memberCollectSubjects);
        return flag ? ResponseEntity.ok("(会员收藏的专题活动)批量变更成功") : ResponseEntity.error("(会员收藏的专题活动)批量变更失败");
    }

    /**
     * (会员收藏的专题活动)新增
     *
     * @param memberCollectSubject (会员收藏的专题活动)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(会员收藏的专题活动)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberCollectSubject memberCollectSubject) {
        boolean flag = memberCollectSubjectService.saveOrUpdate(memberCollectSubject);
        return flag ? ResponseEntity.ok("(会员收藏的专题活动)新增成功") : ResponseEntity.error("(会员收藏的专题活动)新增失败");
    }

    /**
     * (会员收藏的专题活动)更新
     *
     * @param memberCollectSubject (会员收藏的专题活动)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(会员收藏的专题活动)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberCollectSubject memberCollectSubject) {
        boolean flag = memberCollectSubjectService.updateById(memberCollectSubject);
        return flag ? ResponseEntity.ok("(会员收藏的专题活动)更新成功") : ResponseEntity.error("(会员收藏的专题活动)更新失败");
    }

    /**
     * 批量更新(会员收藏的专题活动)
     *
     * @param memberCollectSubjects (会员收藏的专题活动)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(会员收藏的专题活动)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberCollectSubject> memberCollectSubjects) {
        boolean flag = memberCollectSubjectService.updateBatchById(memberCollectSubjects);
        return flag ? ResponseEntity.ok("批量更新(会员收藏的专题活动)成功") : ResponseEntity.error("批量更新(会员收藏的专题活动)失败");
    }

    /**
     * (会员收藏的专题活动)删除
     *
     * @param deleteIds 删除(会员收藏的专题活动)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(会员收藏的专题活动)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = memberCollectSubjectService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(会员收藏的专题活动)删除成功") : ResponseEntity.error("(会员收藏的专题活动)删除失败");
    }
}