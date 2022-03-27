package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.HomeAdv;
import com.sxx.coupon.service.HomeAdvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_home_adv(首页轮播广告)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(首页轮播广告)")
@RequestMapping("homeAdv")
public class HomeAdvController {

    private final HomeAdvService homeAdvService;

    /**
     * 查询(首页轮播广告)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(首页轮播广告)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return homeAdvService.queryPage(params);
    }

    /**
     * (首页轮播广告)详细信息
     *
     * @param homeAdvId (首页轮播广告)Id
     * @return (首页轮播广告)详情信息
     */
    @GetMapping("info/{homeAdvId}")
    @ApiOperation("(首页轮播广告)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long homeAdvId) {
        HomeAdv homeAdv = homeAdvService.getById(homeAdvId);
        return ResponseEntity.ok("data", homeAdv);
    }

    /**
     * (首页轮播广告)批量新增或修改
     *
     * @param homeAdvs 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(首页轮播广告)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<HomeAdv> homeAdvs) {
        boolean flag = homeAdvService.saveOrUpdateBatch(homeAdvs);
        return flag ? ResponseEntity.ok("(首页轮播广告)批量变更成功") : ResponseEntity.error("(首页轮播广告)批量变更失败");
    }

    /**
     * (首页轮播广告)新增
     *
     * @param homeAdv (首页轮播广告)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(首页轮播广告)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody HomeAdv homeAdv) {
        boolean flag = homeAdvService.saveOrUpdate(homeAdv);
        return flag ? ResponseEntity.ok("(首页轮播广告)新增成功") : ResponseEntity.error("(首页轮播广告)新增失败");
    }

    /**
     * (首页轮播广告)更新
     *
     * @param homeAdv (首页轮播广告)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(首页轮播广告)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody HomeAdv homeAdv) {
        boolean flag = homeAdvService.updateById(homeAdv);
        return flag ? ResponseEntity.ok("(首页轮播广告)更新成功") : ResponseEntity.error("(首页轮播广告)更新失败");
    }

    /**
     * 批量更新(首页轮播广告)
     *
     * @param homeAdvs (首页轮播广告)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(首页轮播广告)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<HomeAdv> homeAdvs) {
        boolean flag = homeAdvService.updateBatchById(homeAdvs);
        return flag ? ResponseEntity.ok("批量更新(首页轮播广告)成功") : ResponseEntity.error("批量更新(首页轮播广告)失败");
    }

    /**
     * (首页轮播广告)删除
     *
     * @param deleteIds 删除(首页轮播广告)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(首页轮播广告)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = homeAdvService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(首页轮播广告)删除成功") : ResponseEntity.error("(首页轮播广告)删除失败");
    }
}