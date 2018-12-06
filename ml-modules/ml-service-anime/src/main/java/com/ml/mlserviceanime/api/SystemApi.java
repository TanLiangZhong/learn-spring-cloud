package com.ml.mlserviceanime.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 系统 feign 接口
 *
 * @author liangzhong
 * @version 1.0
 * @date 2018/12/5
 */
@FeignClient(name = "system", decode404 = true)
public interface SystemApi {

    /**
     * 主页
     *
     * @param name
     * @return
     */
    @GetMapping("index/{name}")
    String index(@PathVariable("name") String name);

}
