package com.ml.rabbitmq.controller;

import com.ml.rabbitmq.service.DemoProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RabbitMQ - 控制器
 *
 * @author liangzhong
 * @date 2019/1/23 13:56
 */
@Api("Demo")
@RestController
@RequestMapping("demo")
public class RabbitMqController {

    private final DemoProvider demoProvider;

    @Autowired
    public RabbitMqController(DemoProvider demoProvider) {
        this.demoProvider = demoProvider;
    }

    @ApiOperation("send")
    @GetMapping("send")
    public void send(@ApiParam(value = "值", required = true) @RequestParam(defaultValue = "达摩克利斯之剑") String val) {
        demoProvider.send(val);
    }

    @ApiOperation("sendList")
    @GetMapping("send/list")
    public void sendList() {
        demoProvider.sendList();
    }

}
