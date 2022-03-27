package com.sxx.coupon.controller;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.coupon.entity.HomeSubject;
import com.sxx.coupon.service.HomeSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【sms_home_subject(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-23 23:45:42
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)")
@RequestMapping("homeSubject")
public class HomeSubjectController {

    private final HomeSubjectService homeSubjectService;

    /**
     * 查询(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    @GetMapping("list")
    @ApiOperation("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)列表")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        return homeSubjectService.queryPage(params);
    }

    /**
     * (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)详细信息
     *
     * @param homeSubjectId (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)Id
     * @return (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)详情信息
     */
    @GetMapping("info/{homeSubjectId}")
    @ApiOperation("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)详情")
    @Transactional(rollbackFor = Exception.class)
        public ResponseEntity info(@PathVariable Long homeSubjectId) {
        HomeSubject homeSubject = homeSubjectService.getById(homeSubjectId);
        return ResponseEntity.ok("data", homeSubject);
    }

    /**
     * (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)批量新增或修改
     *
     * @param homeSubjects 增加或修改集合
     * @return 变更状态
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)批量新增或修改")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity saveOrUpdate(@RequestBody List<HomeSubject> homeSubjects) {
        boolean flag = homeSubjectService.saveOrUpdateBatch(homeSubjects);
        return flag ? ResponseEntity.ok("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)批量变更成功") : ResponseEntity.error("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)批量变更失败");
    }

    /**
     * (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)新增
     *
     * @param homeSubject (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)信息
     * @return 新增状态
     */
    @PostMapping("save")
    @ApiOperation("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)新增")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(@RequestBody HomeSubject homeSubject) {
        boolean flag = homeSubjectService.saveOrUpdate(homeSubject);
        return flag ? ResponseEntity.ok("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)新增成功") : ResponseEntity.error("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)新增失败");
    }

    /**
     * (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)更新
     *
     * @param homeSubject (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)信息
     * @return 更新状态
     */
    @PostMapping("update")
    @ApiOperation("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)更新")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity update(@RequestBody HomeSubject homeSubject) {
        boolean flag = homeSubjectService.updateById(homeSubject);
        return flag ? ResponseEntity.ok("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)更新成功") : ResponseEntity.error("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)更新失败");
    }

    /**
     * 批量更新(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)
     *
     * @param homeSubjects (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)信息
     * @return 批量更新状态
     */
    @PostMapping("updateBatch")
    @ApiOperation("批量更新(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateBatch(@RequestBody List<HomeSubject> homeSubjects) {
        boolean flag = homeSubjectService.updateBatchById(homeSubjects);
        return flag ? ResponseEntity.ok("批量更新(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)成功") : ResponseEntity.error("批量更新(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)失败");
    }

    /**
     * (首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)删除
     *
     * @param deleteIds 删除(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)集合
     * @return 删除状态
     */
    @PostMapping("delete")
    @ApiOperation("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)删除")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(@RequestBody List<Long> deleteIds) {
        boolean flag = homeSubjectService.removeByIds(deleteIds);
        return flag ? ResponseEntity.ok("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)删除成功") : ResponseEntity.error("(首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】)删除失败");
    }
}