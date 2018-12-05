package com.ml.system.controller;

import com.google.common.collect.Maps;
import com.ml.system.bo.LoginBo;
import com.ml.system.vo.RestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/11/30
 */
@Api("登陆控制器")
@RestController
@RequestMapping
public class LoginController {

    private final static String TOKEN = "ASDFGHJKL";

    @ApiOperation("主页")
    @GetMapping("index/{name}")
    public String index(@ApiParam("用户名") @PathVariable String name) {
        return "Hello " + name;
    }

    @ApiOperation("登陆")
    @PostMapping("login")
    public RestVo login(@ApiParam(value = "登陆Bo") @RequestBody LoginBo bo) {
        final String n = "admin";
        final String p = "admin";
        System.out.println("LoginController.login");
        System.out.println("loginName = " + bo.getLoginName());
        System.out.println("password = " + bo.getPassword());
        if (StringUtils.isNotBlank(bo.getLoginName()) && n.equals(bo.getLoginName()) && StringUtils.isNotBlank(bo.getPassword()) && p.equals(bo.getPassword())) {
            Map<String, String> map = Maps.newHashMap();
            map.put("token", TOKEN);
            return RestVo.SUCCESS(map);
        }
        return RestVo.FAIL();
    }


}
