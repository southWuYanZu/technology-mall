package com.sxx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.member.entity.MemberReceiveAddress;
import com.sxx.member.mapper.MemberReceiveAddressMapper;
import com.sxx.member.service.MemberReceiveAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 针对表【ums_member_receive_address(会员收货地址)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-11 17:13:19
 */
@Service
@RequiredArgsConstructor
public class MemberReceiveAddressServiceImpl extends ServiceImpl<MemberReceiveAddressMapper, MemberReceiveAddress>
        implements MemberReceiveAddressService{

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<MemberReceiveAddress> query = new Query<>();
        QueryWrapper<MemberReceiveAddress> wrapper = new QueryWrapper<>();
        IPage<MemberReceiveAddress> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page",new PageUtils(page));
    }
}




