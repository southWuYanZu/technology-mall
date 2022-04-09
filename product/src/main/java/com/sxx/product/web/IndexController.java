package com.sxx.product.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sxx.product.entity.Category;
import com.sxx.product.service.CategoryService;
import com.sxx.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * @author admin
 */
@Controller
public class IndexController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/", "index.html"})
    private String indexPage(Model model) {

        //1、查出所有的一级分类
        List<Category> categoryEntities = categoryService.getLevel1Categorys();
        model.addAttribute("categories", categoryEntities);

        return "index";
    }


    /**
     * index/json/catalog.json
     */
    @GetMapping(value = "/index/catalog.json")
    @ResponseBody
    @Cacheable(value = "catalogJson",key = "#root.method.name")
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        String catalogJson = redisTemplate.opsForValue().get("catalogJson");
        if (StringUtils.isEmpty(catalogJson)) {
            Map<String, List<Catelog2Vo>> listMap = categoryService.getCatalogJson();
            String jsonString = JSON.toJSONString(listMap);
            redisTemplate.opsForValue().set("catalogJson", jsonString);
            System.out.println("query db.....");
            return listMap;
        } else {
            System.out.println("cache");
            return JSON.parseObject(catalogJson, new TypeReference<Map<String, List<Catelog2Vo>>>() {
            });
        }
    }

}