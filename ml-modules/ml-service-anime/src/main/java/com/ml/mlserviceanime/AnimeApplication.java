package com.ml.mlserviceanime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 动漫服务
 *
 * @author liangzhong
 * @version 1.0
 * @date 2018-12-03
 */
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
public class AnimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeApplication.class, args);
    }
}
