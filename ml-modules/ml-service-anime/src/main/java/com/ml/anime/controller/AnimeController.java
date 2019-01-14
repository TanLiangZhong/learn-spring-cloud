package com.ml.anime.controller;

import com.ml.anime.service.AnimeService;
import com.ml.bean.anime.entity.Anime;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private AnimeService animeService;

    @Value("${ml.name}")
    private String mlName;

    @ApiOperation("Get 主页")
    @GetMapping("index")
    public String index() {
        return mlName;
    }


    @ApiOperation("根据主键查询")
    @GetMapping("findById/{id}")
    public Anime findById(@ApiParam(value = "主键", required = true) @PathVariable("id") Long id) {
        return animeService.findById(id);
    }


}
