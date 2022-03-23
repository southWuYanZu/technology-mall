package com.sxx.coupon.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.ApiOperation;1
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_home_subject_spu(专题商品)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 21:03:52
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(专题商品)")
@RequestMapping("homeSubjectSpu")
public class HomeSubjectSpuController {

    private final HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 查询(专题商品)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(专题商品)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return homeSubjectSpuService.queryPage(params);
    }

    /**
     * (专题商品)详细信息
     *
     * @param homeSubjectSpuId (专题商品)Id
     * @return (专题商品)详情信息
     */
    @GetMapping("info/{homeSubjectSpuId}")
    @ApiOperation("(专题商品)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long homeSubjectSpuId) {
        HomeSubjectSpu homeSubjectSpu = homeSubjectSpuService.getById(homeSubjectSpuId);
        return ResponseEntity.ok("data", homeSubjectSpu);
    }

    /**
     * (专题商品)批量新增或修改
     *
     * @param homeSubjectSpus 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(专题商品)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<HomeSubjectSpu> homeSubjectSpus) {
        boolean flag = homeSubjectSpuService.saveOrUpdateBatch(homeSubjectSpus);
        return flag ? ResponseEntity.ok("(专题商品)批量变更成功") : ResponseEntity.error("(专题商品)批量变更失败");
    }

    /**
     * (专题商品)新增
     *
     * @param homeSubjectSpu (专题商品)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(专题商品)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody HomeSubjectSpu homeSubjectSpu) {
        boolean flag = homeSubjectSpuService.saveOrUpdate(homeSubjectSpu);
        return flag ? ResponseEntity.ok("(专题商品)新增成功") : ResponseEntity.error("(专题商品)新增失败");
    }

    /**
     * (专题商品)更新
     *
     * @param homeSubjectSpu (专题商品)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(专题商品)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody HomeSubjectSpu homeSubjectSpu) {
        boolean flag = homeSubjectSpuService.updateById(homeSubjectSpu);
        return flag ? ResponseEntity.ok("(专题商品)更新成功") : ResponseEntity.error("(专题商品)更新失败");
    }

    /**
     * 批量更新(专题商品)
     *
     * @param homeSubjectSpus (专题商品)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(专题商品)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<HomeSubjectSpu> homeSubjectSpus) {
        boolean flag = homeSubjectSpuService.updateBatchById(homeSubjectSpus);
        return flag ? ResponseEntity.ok("批量更新(专题商品)成功") : ResponseEntity.error("批量更新(专题商品)失败");
    }

    /**
     * (专题商品)删除
     *
     * @param deleteIds 删除(专题商品)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(专题商品)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = homeSubjectSpuService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(专题商品)删除成功") : ResponseEntity.error("(专题商品)删除失败");
    }
}