package com.ml.jpademo.controller;

import com.ml.bean.anime.bo.AnimeBo;
import com.ml.bean.anime.vo.AnimeVo;
import com.ml.bean.common.vo.RestVo;
import com.ml.jpademo.entity.Anime;
import com.ml.jpademo.service.impl.AnimeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/11/30
 */
@Api("主页")
@RestController
@RequestMapping("/anime/anime")
public class AnimeController {

    private final AnimeServiceImpl animeService;

    @Value("${ml.name}")
    private String mlName;

    @Autowired
    public AnimeController(AnimeServiceImpl animeService) {
        this.animeService = animeService;
    }

    @ApiOperation("Get 主页")
    @GetMapping("index")
    public String index() {
        return mlName;
    }

    @ApiOperation("根据主键查询")
    @GetMapping("findById/{id}")
    public Anime findById(@ApiParam(value = "主键", required = true) @PathVariable("id") Long id) {
        return animeService.findById(id).orElse(null);
    }

    @ApiOperation("保存")
    @PostMapping("save")
    public RestVo<AnimeVo> save(@ApiParam(value = "动漫对象", required = true) @RequestBody AnimeBo bo) {
        return RestVo.success(animeService.save(bo));
    }

    @ApiOperation("查询所有")
    @GetMapping("findAll")
    public RestVo<Anime> findAll() {
        return RestVo.success(animeService.findAllVo());
    }
}
