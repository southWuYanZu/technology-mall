package com.sxx.product.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sxx.product.entity.Category;
import com.sxx.product.service.CategoryService;
import com.sxx.product.vo.Catelog2Vo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;


/**
 * @author admin
 */
@RestController
@ApiIgnore
@RequiredArgsConstructor
public class IndexController {

    private final StringRedisTemplate redisTemplate;

    private final CategoryService categoryService;

    @ApiIgnore
    @GetMapping(value = {"/", "index.html"})
    private ModelAndView indexPage(Model model) {

        //1、查出所有的一级分类
        List<Category> categoryEntities = categoryService.getLevel1Categorys();
        model.addAttribute("categories", categoryEntities);

        return new ModelAndView("index");
    }


    @ApiIgnore
    @GetMapping(value = "/index/json/catalog.json")
    @ResponseBody
//    @Cacheable(value = "catalogJson",key = "#root.method.name")
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
