package com.sxx.member.mapper;

import com.sxx.member.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author shenxianxin
*  针对表【ums_member(会员)】的数据库操作Mapper
* @since 2021-12-02 18:31:53
* @Entity com.sxx.member.entity.Member
*/
@Mapper
public interface MemberMapper extends BaseMapper<Member> {

}




