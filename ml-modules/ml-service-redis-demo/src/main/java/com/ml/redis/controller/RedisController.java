package com.ml.redis.controller;

import com.ml.bean.anime.entity.Anime;
import com.ml.redis.service.RedisListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Redis - Controller
 *
 * @author liangzhong
 * @date 2019/1/22 15:03
 */
@Api("Demo")
@RestController
@RequestMapping("redis/demo")
public class RedisController {

    @Autowired
    private RedisListService redisService;

    @ApiOperation("Set String")
    @PutMapping("set/string/{key}")
    public void setString(@ApiParam(value = "键", required = true) @PathVariable("key") String key,
                          @ApiParam(value = "值", required = true) @RequestParam(value = "val", defaultValue = "达摩克利斯之剑") String val) {
        redisService.setString(key, val);
    }

    @ApiOperation("Get String")
    @GetMapping("get/{key}")
    public Object getString(@ApiParam(value = "键", required = true) @PathVariable("key") String key) {
        return redisService.getString(key);
    }

    @ApiOperation("Set List")
    @PutMapping("set/list/{key}")
    public Long setList(@ApiParam(value = "键", required = true) @PathVariable String key, @ApiParam(value = "值", required = true) @RequestBody List<String> list) {
        if (list.isEmpty()) {
            List<Anime> animeList = Anime.getParam();
            animeList.forEach(a -> list.add(a.getName()));
        }
        return redisService.setList(key, list);
    }

    @ApiOperation("Get List")
    @GetMapping("get/list/{key}")
    public Object getList(@ApiParam(value = "键", required = true) @PathVariable("key") String key) {
        return redisService.getList(key);
    }

    @ApiOperation("Delete Value")
    @DeleteMapping("delete/{key}")
    public Boolean delete(@ApiParam(value = "键", required = true) @PathVariable("key") String key) {
        return redisService.delete(key);
    }
}
