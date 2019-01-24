package com.ml.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Rabbitmq Demo - Main
 *
 * @author liangzhong
 * @version 1.0
 * @date 2018-12-22
 */
@EnableSwagger2
@EnableFeignClients(basePackages = "com.ml.common.feign")
@SpringCloudApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

}

