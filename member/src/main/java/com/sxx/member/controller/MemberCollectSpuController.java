package com.sxx.member.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberCollectSpu;
import com.sxx.member.service.MemberCollectSpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【ums_member_collect_spu(会员收藏的商品)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(会员收藏的商品)")
@RequestMapping("MemberCollectSpu")
public class MemberCollectSpuController {

    private final MemberCollectSpuService memberCollectSpuService;

    /**
     * 查询(会员收藏的商品)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(会员收藏的商品)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return memberCollectSpuService.queryPage(params);
    }

    /**
     * (会员收藏的商品)详细信息
     *
     * @param memberCollectSpuId (会员收藏的商品)Id
     * @return (会员收藏的商品)详情信息
     */
    @GetMapping("info/{memberCollectSpuId}")
    @ApiOperation("(会员收藏的商品)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long memberCollectSpuId) {
        MemberCollectSpu memberCollectSpu = memberCollectSpuService.getById(memberCollectSpuId);
        return ResponseEntity.ok("data", memberCollectSpu);
    }

    /**
     * (会员收藏的商品)批量新增或修改
     *
     * @param memberCollectSpus 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(会员收藏的商品)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<MemberCollectSpu> memberCollectSpus) {
        boolean flag = memberCollectSpuService.saveOrUpdateBatch(memberCollectSpus);
        return flag ? ResponseEntity.ok("(会员收藏的商品)批量变更成功") : ResponseEntity.error("(会员收藏的商品)批量变更失败");
    }

    /**
     * (会员收藏的商品)新增
     *
     * @param memberCollectSpu (会员收藏的商品)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(会员收藏的商品)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody MemberCollectSpu memberCollectSpu) {
        boolean flag = memberCollectSpuService.saveOrUpdate(memberCollectSpu);
        return flag ? ResponseEntity.ok("(会员收藏的商品)新增成功") : ResponseEntity.error("(会员收藏的商品)新增失败");
    }

    /**
     * (会员收藏的商品)更新
     *
     * @param memberCollectSpu (会员收藏的商品)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(会员收藏的商品)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody MemberCollectSpu memberCollectSpu) {
        boolean flag = memberCollectSpuService.updateById(memberCollectSpu);
        return flag ? ResponseEntity.ok("(会员收藏的商品)更新成功") : ResponseEntity.error("(会员收藏的商品)更新失败");
    }

    /**
     * 批量更新(会员收藏的商品)
     *
     * @param memberCollectSpus (会员收藏的商品)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(会员收藏的商品)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<MemberCollectSpu> memberCollectSpus) {
        boolean flag = memberCollectSpuService.updateBatchById(memberCollectSpus);
        return flag ? ResponseEntity.ok("批量更新(会员收藏的商品)成功") : ResponseEntity.error("批量更新(会员收藏的商品)失败");
    }

    /**
     * (会员收藏的商品)删除
     *
     * @param deleteIds 删除(会员收藏的商品)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(会员收藏的商品)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = memberCollectSpuService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(会员收藏的商品)删除成功") : ResponseEntity.error("(会员收藏的商品)删除失败");
    }
}