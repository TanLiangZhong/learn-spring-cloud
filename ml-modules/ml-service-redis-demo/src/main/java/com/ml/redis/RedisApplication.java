package com.ml.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Data Redis Demo - Main
 * @author liangzhong
 * @version 1.0
 * @date 2018-12-22
 */
@EnableSwagger2
@EnableFeignClients
@SpringCloudApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}

