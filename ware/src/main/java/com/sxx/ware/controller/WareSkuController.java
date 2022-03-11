package com.sxx.ware.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

/**
 * 针对表【wms_ware_sku(商品库存)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-10 21:53:27
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(商品库存)")
@RequestMapping("/WareSku")
public class WareSkuController {

}
