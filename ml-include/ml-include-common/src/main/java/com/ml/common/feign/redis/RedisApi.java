package com.ml.common.feign.redis;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liangzhong
 * @date 2019/1/23 20:15
 */
@FeignClient(name = "ml-service-redis-demo", path = "/redis/demo", decode404 = true)
public interface RedisApi {


    /**
     * setRedis
     *
     * @param key
     * @param val
     */
    @ApiOperation("Set String")
    @PutMapping("set/string/{key}")
    void setString(@ApiParam(value = "键", required = true) @PathVariable("key") String key,
                   @ApiParam(value = "值", required = true) @RequestParam(value = "val", defaultValue = "达摩克利斯之剑") String val);
}
