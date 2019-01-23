package com.ml.rabbitmq.config;

import com.ml.rabbitmq.constant.RabbitConst;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMq - 配置
 *
 * @author liangzhong
 * @date 2019/1/23 14:27
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 申明交换机
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitConst.QueueEnum.ML_MQ.getExchangeName());
    }

    /**
     * ml 消息队列
     *
     * @return
     */
    @Bean
    public Queue mlQueue() {
        // 队列名称
        final String name = RabbitConst.QueueEnum.ML_MQ.getQueueName();
        // 如果我们声明一个持久队列，则为true（队列将在服务器重启后继续存在）
        final boolean durable = true;
        // 如果我们声明一个独占队列，则为true（该队列仅由声明者的连接使用）
        final boolean exclusive = false;
        // 如果服务器在不再使用时应删除队列，则为true
        final boolean autoDelete = true;
        return new Queue(name, durable, exclusive, autoDelete);
    }

    /**
     * 绑定队列和交换机
     *
     * @return
     */
    @Bean
    public Binding mlBind() {
        return BindingBuilder.bind(mlQueue()).to(directExchange()).with(RabbitConst.QueueEnum.ML_MQ.getRoutingKeyName());
    }

}
