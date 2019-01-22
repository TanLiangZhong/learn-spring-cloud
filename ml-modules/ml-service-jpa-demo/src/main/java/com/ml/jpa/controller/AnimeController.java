package com.ml.jpa.controller;

import com.ml.bean.anime.bo.AnimeBo;
import com.ml.bean.anime.vo.AnimeVo;
import com.ml.jpa.entity.Anime;
import com.ml.jpa.entity.PageBo;
import com.ml.jpa.service.impl.AnimeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/11/30
 */
@Api("主页")
@RestController
@RequestMapping("jap/demo")
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
    public void save(@ApiParam(value = "动漫对象", required = true) @RequestBody AnimeBo bo) {
        animeService.saveAll();
    }

    @ApiOperation("根据Id删除")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        animeService.deleteById(id);
    }

    @ApiOperation("删除所有")
    @DeleteMapping("delete/all")
    public void delete() {
        animeService.deleteAll();
    }

    @ApiOperation("查询所有")
    @GetMapping("findAll")
    public List<AnimeVo> findAll() {
        return animeService.findAllVo();
    }

    @ApiOperation("分页查询")
    @PostMapping("findPage")
    public Page<Anime> findPage(@ApiParam(value = "分页Bo", required = true) @RequestBody PageBo<AnimeBo> pageBo) {
        return animeService.findPage(pageBo);
    }
}
