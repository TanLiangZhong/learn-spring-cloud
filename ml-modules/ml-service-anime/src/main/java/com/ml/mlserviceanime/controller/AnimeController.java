package com.ml.mlserviceanime.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/11/30
 */
@Api("主页")
@RestController
@RequestMapping()
public class AnimeController {

    @ApiOperation("Get 主页")
    @GetMapping("index/{name}")
    public String index(@ApiParam("名称") @PathVariable String name) {
        return "Hello " + name;
    }

    @ApiOperation("Post 主页")
    @PostMapping("index")
    public String index(@ApiParam("名称") @RequestParam String name, @ApiParam("动漫") @RequestParam String anime) {
        return "Hello " + name + " !!! " + anime;
    }

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public AnimeController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @ApiOperation("测试")
    @GetMapping("test")
    public String query() {
        final List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> list = discoveryClient.getInstances(service);
            for (ServiceInstance instance : list) {
                System.out.println(instance.getUri() + "/" + service + " - " + instance.getServiceId());
            }
        }
        return restTemplate.getForObject("http://SYSTEM/system/index/谭", String.class);
    }
}
