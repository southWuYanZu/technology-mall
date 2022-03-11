package com.sxx.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberCollectSubject;

import java.util.Map;

/**
* 针对表【ums_member_collect_subject(会员收藏的专题活动)】的数据库操作Service
*
* @author Mr.shen
* @since 2022-03-11 17:13:19
*/
public interface MemberCollectSubjectService extends IService<MemberCollectSubject> {

    /**
     * 查询ums_member_collect_subject(会员收藏的专题活动)列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
