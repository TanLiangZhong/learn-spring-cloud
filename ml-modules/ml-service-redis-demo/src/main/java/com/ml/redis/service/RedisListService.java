package com.ml.redis.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis 字符类型操作
 *
 * @author liangzhong
 * @date 2019/1/24 10:18
 */
@Service
public class RedisListService {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * String 类型数据操作
     *
     * @param key
     * @param val
     * @return
     */
    public void setString(String key, String val) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        // String类型数据存储，不设置过期时间，永久性保存
        valueOperations.set(key, val);
        // String类型数据存储，设置过期时间为80秒，采用TimeUnit控制时间单位
        valueOperations.set(key + "_Time", val + "Time", 77, TimeUnit.SECONDS);
        // 判断key值是否存在，存在则不存储，不存在则存储
        valueOperations.setIfAbsent(key, val + "My_Redis");
        valueOperations.setIfAbsent(key + "1", "My_Redis_111");
    }

    /**
     * String 类型数据操作
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }

    /**
     * list (列表) 类型数据操作
     *
     * @param key
     * @param val
     * @return
     */
    public Long setList(String key, List<String> val) {
        ListOperations<String, Object> listListOperations = redisTemplate.opsForList();
        Long aLong = listListOperations.leftPushAll(key, val);
        return aLong;
    }

    /**
     * list (列表) 类型数据操作
     *
     * @param key
     * @return
     */
    public List getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * Hash 类型数据操作
     *
     * @param key
     * @param val
     */
    public void setHash(String key, Map<String, String> val) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key, val);
    }

    /**
     * Hash 类型数据操作
     *
     * @param key
     */
    public List<String> getHash(String key) {

        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        List<String> reslutMapList = hashOperations.values(key);
        return reslutMapList;
    }


    public void hash() {
        final String key = "ml_Hash";
        Map<String, String> val = new HashMap<>();

        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        Set<String> resultMapSet = hashOperations.keys(key);
        List<String> reslutMapList = hashOperations.values(key);
        String value = (String) hashOperations.get("map1", "key1");

        System.out.println("resultMapSet = " + resultMapSet);
        System.out.println("reslutMapList = " + reslutMapList);
    }
}
