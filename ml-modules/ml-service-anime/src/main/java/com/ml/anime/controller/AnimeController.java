package com.ml.anime.controller;

import com.ml.anime.api.SystemApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/11/30
 */
@Api("主页")
@RestController
@RequestMapping
public class AnimeController {

    @Autowired
    private SystemApi systemApi;

    @ApiOperation("Get 主页")
    @GetMapping("index/{name}")
    public String index(@ApiParam("名称") @PathVariable String name) {
        return "Hello " + name;
    }

    @ApiOperation("Post 主页")
    @PostMapping("index")
    public String index(@ApiParam("名称") @RequestParam String name, @ApiParam("动漫") @RequestParam String anime) {
        return "Hello " + name + " !!! " + anime;
    }

    @ApiOperation("测试 Feign")
    @GetMapping("test")
    public String test() {
        return systemApi.index("谭良忠");
    }

}