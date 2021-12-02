package com.sxx.member.mapper;

import com.sxx.member.entity.GrowthChangeHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author shenxianxin
* @description 针对表【ums_growth_change_history(成长值变化历史记录)】的数据库操作Mapper
* @createDate 2021-12-02 18:31:53
* @Entity com.sxx.member.entity.GrowthChangeHistory
*/
@Mapper
public interface GrowthChangeHistoryMapper extends BaseMapper<GrowthChangeHistory> {

}



