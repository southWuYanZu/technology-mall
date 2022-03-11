package com.sxx.ware.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

/**
 * 针对表【wms_ware_info(仓库信息)】的数据库操作Controller
 *
 * @author Mr.shen
 * @since 2022-03-10 21:53:27
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "(仓库信息)")
@RequestMapping("/WareInfo")
public class WareInfoController {

}