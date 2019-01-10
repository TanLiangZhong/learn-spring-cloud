package com.ml.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页 - Controller
 *
 * @author liangzhong
 * @date 2019/1/10
 */
@RestController
@Api(description = "主页控制器")
@RequestMapping(value = "/system/index")
public class IndexController {

    @Value("${ml.name}")
    private String mlName;

    @ApiOperation("Hello")
    @GetMapping("hello")
    public String index() {
        return "Hello " + mlName;
    }

}
