package com.sxx.elasticsearch.controller;


import com.sxx.elasticsearch.service.MallSearchService;
import com.sxx.elasticsearch.vo.SearchParam;
import com.sxx.elasticsearch.vo.SearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shenxianxin
 * @since 2022/4/3 21:43:06
 */

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final MallSearchService mallSearchService;

    /**
     * 自动将页面提交过来的所有请求参数封装成我们指定的对象
     *
     * @param param
     * @return
     */
    @GetMapping(value = "/list.html")
    public String listPage(SearchParam param, Model model, HttpServletRequest request) {

        param.set_queryString(request.getQueryString());

        //1、根据传递来的页面的查询参数，去es中检索商品
        SearchResult result = mallSearchService.search(param);

        model.addAttribute("result", result);

        return "list";
    }

}
