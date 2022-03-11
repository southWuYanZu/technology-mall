package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberCollectSpu;
import com.sxx.member.mapper.MemberCollectSpuMapper;
import com.sxx.member.service.MemberCollectSpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_member_collect_spu(会员收藏的商品)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class MemberCollectSpuServiceImpl extends ServiceImpl<MemberCollectSpuMapper, MemberCollectSpu>
        implements MemberCollectSpuService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<MemberCollectSpu> query = new Query<>();
        QueryWrapper<MemberCollectSpu> wrapper = new QueryWrapper<>();
        IPage<MemberCollectSpu> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




