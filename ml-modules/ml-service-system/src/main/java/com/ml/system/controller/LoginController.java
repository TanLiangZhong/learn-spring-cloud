package com.ml.system.controller;

import com.ml.system.vo.RestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/11/30
 */
@Api("登陆控制器")
@RestController
public class LoginController {

    @ApiOperation("主页")
    @GetMapping("index/{name}")
    public String index(@ApiParam("用户名") @PathVariable String name) {
        return "Hello " + name;
    }

    @ApiOperation("登陆")
    @PostMapping("login")
    public RestVo login(@ApiParam("用户名") @RequestParam String loginName, @ApiParam(value = "密码", name = "password") @RequestParam String password) {
        final String n = "admin";
        final String p = "admin";
        System.out.println("LoginController.login");
        System.out.println("loginName = " + loginName);
        System.out.println("password = " + password);
        if (StringUtils.isNotBlank(loginName) && n.equals(loginName) && StringUtils.isNotBlank(password) && p.equals(password)) {
            return RestVo.SUCCESS();
        }
        return RestVo.SUCCESS();
    }


}
