package com.ml.redis.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis - 配置
 *
 * @author liangzhong
 * @date 2019/1/22 14:36
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

}
