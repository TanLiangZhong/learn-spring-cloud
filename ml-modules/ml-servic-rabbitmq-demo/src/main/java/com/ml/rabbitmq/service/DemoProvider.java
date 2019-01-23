package com.ml.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Demo - 提供商
 *
 * @author liangzhong
 * @date 2019/1/23 13:58
 */
@Service
public class DemoProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String data) {
        final int length = 100;
        for (int i = 0; i < length; i++) {
            // 发送
            rabbitTemplate.convertAndSend(DemoConsumer.ML_MQ, data + " --- " + i);
        }
    }
}
