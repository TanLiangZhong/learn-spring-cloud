package com.ml.mlserviceanime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 动漫服务
 *
 * @author liangzhong
 * @version 1.0
 * @date 2018-12-03
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class AnimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeApplication.class, args);
    }

    /**
     * RestTemplate 是由 Spring Boot 提供而不是 Spring Cloud ,无负载功能, 为了方便开发者, Spring Cloud 团队提供了一个 @LoadBalanced 注解（默认采用轮训算法）
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
