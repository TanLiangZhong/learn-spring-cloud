package com.ml.common.feign.redis;

import com.ml.bean.anime.entity.Anime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liangzhong
 * @date 2019/1/23 20:15
 */
@FeignClient(name = "ml-service-redis-demo", path = "/redis/demo", decode404 = true)
public interface RedisApi {

    /**
     * set
     *
     * @param key
     * @param list
     * @return
     */
    @PostMapping("set/list/{key}")
    Long setList(@PathVariable String key, @RequestBody List<Anime> list);
}
