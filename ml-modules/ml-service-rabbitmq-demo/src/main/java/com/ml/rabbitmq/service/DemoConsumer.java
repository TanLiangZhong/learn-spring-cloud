package com.ml.rabbitmq.service;

import com.ml.rabbitmq.constant.RabbitConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Demo - 消费者
 *
 * @author liangzhong
 * @date 2019/1/23 13:58
 */
@Slf4j
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
//            Thread.sleep(1000);
            log.info("时间：" + System.currentTimeMillis() + "   ML_MQ Data :  " + data);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RabbitListener(queues = RabbitConst.DELAY_QUEUE)
    public void handlerTestMqMl(String data) {
        try {
            Thread.sleep(1000);
            log.info("时间：" + System.currentTimeMillis());
            System.out.println("DELAY_QUEUE Data :  " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
