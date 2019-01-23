package com.ml.anime.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/11/30
 */
@Api("主页")
@RestController
@RequestMapping("/anime/anime")
public class AnimeController {


    @Value("${ml.name}")
    private String mlName;

    @ApiOperation("Get 主页")
    @GetMapping("index")
    public String index() {
        return mlName;
    }

}
