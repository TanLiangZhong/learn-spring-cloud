package com.ml.rabbitmq.service;

import com.ml.bean.anime.entity.Anime;
import com.ml.rabbitmq.constant.RabbitConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Demo - 提供者
 *
 * @author liangzhong
 * @date 2019/1/23 13:58
 */
@Slf4j
@Service
public class DemoProvider {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public DemoProvider(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String data) {
        final int length = 2;
        for (int i = 0; i < length; i++) {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            rabbitTemplate.convertAndSend(RabbitConst.QueueEnum.ML_MQ.getQueueName(), data);
        }
    }

    public void sendList() {
        int[] timeOut = {6000, 3000, 1000};
//        int[] timeOut = {10000, 30000, 60000};
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            this.rabbitTemplate.convertAndSend("DEAD_LETTER_EXCHANGE", RabbitConst.QueueEnum.DELAY_QUEUE.getRoutingKeyName(), "Hello Time : " + timeOut[finalI], message -> {
                message.getMessageProperties().setExpiration(String.valueOf(timeOut[finalI]));
                log.info("时间：" + System.currentTimeMillis() + " Time: "+ timeOut[finalI]);
                return message;
            });
        }

//        rabbitTemplate.convertAndSend(RabbitConst.QueueEnum.ML_MQ.getQueueName(), Anime.getParam());
    }

}
