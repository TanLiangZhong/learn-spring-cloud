package com.ml.redis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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

    @Autowired(required = false)
    private RedisTemplate<String, String> redisTemplate;


    @ApiOperation("Set Value")
    @GetMapping("set")
    public void setValue(@ApiParam(value = "键", required = true) @RequestParam String key, @ApiParam(value = "值", required = true) @RequestParam String val) {
        // -----------------String类型数据操作 start--------------------
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        // String类型数据存储，不设置过期时间，永久性保存
        valueOperations.set(key, val);
        // String类型数据存储，设置过期时间为80秒，采用TimeUnit控制时间单位
        valueOperations.set(key + "_Time", val + "Time", 77, TimeUnit.SECONDS);
        // 判断key值是否存在，存在则不存储，不存在则存储
        valueOperations.setIfAbsent(key, val + "My_Redis");
        valueOperations.setIfAbsent(key + "1", "My_Redis_111");
    }


    @ApiOperation("Get Value")
    @GetMapping("get/{key}")
    public String getValue(@ApiParam(value = "键", required = true) @PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
