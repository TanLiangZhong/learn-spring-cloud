package com.ml.system.controller;

import com.ml.common.feign.anime.AnimeApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页 - Controller
 *
 * @author liangzhong
 * @version 1.0
 * @date 2019/1/10
 */
@RestController
@Api(description = "主页控制器")
@RequestMapping(value = "/system/index")
public class IndexController {

    @Autowired
    private AnimeApi animeApi;

    @ApiOperation("Hello")
    @GetMapping("hello")
    public String index() {
        return animeApi.index();
    }

}
