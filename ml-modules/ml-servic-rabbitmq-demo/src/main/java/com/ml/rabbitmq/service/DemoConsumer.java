package com.ml.rabbitmq.service;

import com.ml.rabbitmq.constant.RabbitConst;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Demo - 消费者
 *
 * @author liangzhong
 * @date 2019/1/23 13:58
 */
@Component
public class DemoConsumer {

    /**
     * 处理 rabbitMQ 测试
     *
     * @param data
     */
    @RabbitListener(queues = RabbitConst.ML_MQ)
    public void handlerTestMq(String data) {
        try {
            Thread.sleep(10000);
            System.out.println("DemoConsumer data = " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
