package com.ml.common.feign.anime;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liangzhong
 * date: 2019/1/11 15:35
 */
@FeignClient(name = "ml-service-anime", path = "/anime/anime", decode404 = true)
public interface AnimeApi {


    /**
     * 主页
     *
     * @return
     */
    @GetMapping("/index")
    String index();

}
