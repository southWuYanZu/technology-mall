package com.sxx.elasticsearch.service;


import com.sxx.elasticsearch.vo.SearchParam;
import com.sxx.elasticsearch.vo.SearchResult;

/**
 * @author shenxianxin
 * @since 2022/4/3 21:43:06
 */
public interface MallSearchService {

    /**
     * 检索Es sku索引的所有参数
     *
     * @param param 检索的所有参数
     * @return 返回检索的结果，里面包含页面需要的所有信息
     */
    SearchResult search(SearchParam param);
}
