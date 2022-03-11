package com.sxx.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberCollectSpu;

import java.util.Map;

/**
* 针对表【ums_member_collect_spu(会员收藏的商品)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-11 17:13:19
*/
public interface MemberCollectSpuService extends IService<MemberCollectSpu> {

    /**
     * 查询ums_member_collect_spu(会员收藏的商品)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
