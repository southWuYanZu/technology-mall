package com.sxx.member.mapper;

import com.sxx.member.entity.MemberLevel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author shenxianxin
* @description 针对表【ums_member_level(会员等级)】的数据库操作Mapper
* @createDate 2021-12-02 18:31:53
* @Entity com.sxx.member.entity.MemberLevel
*/
@Mapper
public interface MemberLevelMapper extends BaseMapper<MemberLevel> {

}



