package com.ml.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 系统管理服务
 *
 * @author liangzhong
 * @version 1.0
 * @date 2018-11-30
 */
@EnableSwagger2
@EnableFeignClients(basePackages = "com.ml.common.feign")
@SpringCloudApplication
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
