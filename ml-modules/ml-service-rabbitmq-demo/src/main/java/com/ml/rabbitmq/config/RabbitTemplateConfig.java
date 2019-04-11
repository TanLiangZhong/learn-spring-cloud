package com.ml.rabbitmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * MQ 配置
 *
 * @author liangzhong
 * @date 2019/2/22 11:36
 */
//@Component
public class RabbitTemplateConfig implements RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        // 指定 ReturnCallback
        rabbitTemplate.setReturnCallback(this);
        // 指定 ConfirmCallback
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("消息唯一标识: " + correlationData);
        System.out.println("确认结果： " + ack);
        System.out.println("失败原因： " + cause);
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText,
                                String exchange, String routingKey) {
        System.out.println("返回的消息 = " + message);
        System.out.println("回复代码 = " + replyCode);
        System.out.println("回复文本 = " + replyText);
        System.out.println("交换机 = " + exchange);
        System.out.println("路由密钥 = " + routingKey);
    }
}
