package com.sxx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.product.entity.SpuComment;
import com.sxx.product.service.SpuCommentService;
import com.sxx.product.mapper.SpuCommentMapper;
import org.springframework.stereotype.Service;

/**
* @author shenxianxin
*  针对表【pms_spu_comment(商品评价)】的数据库操作Service实现
* @since 2021-12-02 18:42:19
*/
@Service
public class SpuCommentServiceImpl extends ServiceImpl<SpuCommentMapper, SpuComment>
    implements SpuCommentService{

}




