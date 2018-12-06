package com.ml.mlserviceanime.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 feign 拦截器
 *
 * @author liangzhong
 * @version 1.0
 * @date 2018/12/6
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("token", "10086");
    }
}
