package com.sxx.member.service;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author shenxianxin
*  针对表【ums_member(会员)】的数据库操作Service
* @since 2021-12-02 18:31:53
*/
public interface MemberService extends IService<Member> {


    /**
     * 分页查询会员列表
     *
     * @param params 查询条件以及参数
     * @return 分页详情
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
