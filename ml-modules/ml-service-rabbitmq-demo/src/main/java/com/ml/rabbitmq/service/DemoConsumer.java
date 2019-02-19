package com.ml.rabbitmq.service;

import com.alibaba.fastjson.JSON;
import com.ml.bean.anime.entity.Anime;
import com.ml.common.feign.redis.RedisApi;
import com.ml.rabbitmq.constant.RabbitConst;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Demo - 消费者
 *
 * @author liangzhong
 * @date 2019/1/23 13:58
 */
@Component
public class DemoConsumer {

    @Autowired(required = false)
    private RedisApi redisApi;

    /**
     * 处理 rabbitMQ 测试
     *
     * @param data
     */
//    @RabbitListener(queues = RabbitConst.ML_MQ)
    public void handlerTestMq(String data) {
        try {
            Thread.sleep(10000);
            System.out.println("DemoConsumer data = " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理 rabbitMQ 测试
     *
     * @param data
     */
    @RabbitListener(queues = RabbitConst.ML_MQ)
    public void handlerTestMq(Map<String, String> data) {
        try {
            //Thread.sleep(1000);
            redisApi.setString(data.get("key"), data.get("val"));
            System.out.println("JSON.toJSONString(data) = " + JSON.toJSONString(data));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
