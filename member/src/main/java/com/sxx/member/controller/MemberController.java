package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.Member;
import com.sxx.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 针对表【ums_member(会员)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-10 23:30:48
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员)")
@RequestMapping("member/member")
public class MemberController {

    private final MemberService memberService;

    /**
     * 分页查询会员列表
     *
     * @param params 查询条件以及参数
     * @return 分页详情
     */
    @GetMapping("list")
    @ApiOperation("获取会员列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberService.queryPage(params);
    }


    /**
     * 会员新增
     *
     * @param member 会员信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("会员新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody Member member) {
        boolean flag = memberService.saveOrUpdate(member);
        return flag ? ResponseEntity.ok("会员新增成功") : ResponseEntity.error("会员新增失败");
    }

    @PostMapping("delete")
    @ApiOperation("会员删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Member> members) {
        List<Long> ids = members.stream().map(Member::getId).collect(Collectors.toList());
        boolean flag = memberService.removeByIds(ids);
        return flag ? ResponseEntity.ok("会员删除成功") : ResponseEntity.error("会员删除失败");
    }
}
