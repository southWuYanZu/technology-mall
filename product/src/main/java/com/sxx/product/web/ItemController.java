package com.sxx.product.web;

import com.sxx.product.service.SkuInfoService;
import com.sxx.product.vo.SkuItemVo;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.concurrent.ExecutionException;


/**
 * @author admin
 */
@RestController
@ApiIgnore
@RequiredArgsConstructor
public class ItemController {

    private final SkuInfoService skuInfoService;

    /**
     * 展示当前sku的详情
     *
     * @param skuId id
     * @return info
     */
    @ApiIgnore
    @GetMapping("sku/{skuId}.html")
    public ModelAndView skuItem(@PathVariable("skuId") Long skuId, Model model) throws ExecutionException, InterruptedException {

        System.out.println("准备查询" + skuId + "详情");

        SkuItemVo vos = skuInfoService.item(skuId);

        model.addAttribute("item", vos);
        ModelAndView modelAndView = new ModelAndView("item");
        return modelAndView;
    }
}