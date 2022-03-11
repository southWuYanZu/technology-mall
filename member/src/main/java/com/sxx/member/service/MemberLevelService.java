package com.sxx.member.service;

import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author shenxianxin
 * 针对表【ums_member_level(会员等级)】的数据库操作Service
 * @since 2021-12-02 18:31:53
 */
public interface MemberLevelService extends IService<MemberLevel> {


    /**
     * 查询会员等级列表
     *
     * @param params 分页条件
     * @return 分页集
     */
    ResponseEntity queryPage(Map<String, Object> params);
}
