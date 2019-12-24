package com.ml.redis.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis - 配置
 *
 * @author liangzhong
 * @date 2019/1/22 14:36
 */
@Configuration
@RequiredArgsConstructor
public class RedisConfig extends CachingConfigurerSupport {

    private final RedisTemplate redisTemplate;

    /**
     * 配置Redis防止乱码
     *
     * @return
     */
    @Bean
    public RedisTemplate redisTemplateInit() {
        //设置序列化Key的实例化对象
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        //设置序列化Value的实例化对象
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);
        return redisTemplate;
    }
}
