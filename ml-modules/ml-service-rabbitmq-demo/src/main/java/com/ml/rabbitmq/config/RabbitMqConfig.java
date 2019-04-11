package com.ml.rabbitmq.config;

import com.ml.rabbitmq.constant.RabbitConst;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


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


    private final static String X_DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";

    private final static String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    // 创建一个延时队列
    @Bean
    public Queue delayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", RabbitConst.QueueEnum.ML_MQ.getExchangeName());
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", RabbitConst.QueueEnum.ML_MQ.getRoutingKeyName());
        return new Queue("DELAY_QUEUE", true, false, false, params);
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        //第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange("DEAD_LETTER_EXCHANGE", true, false);
    }

    @Bean
    //把立即消费的队列和立即消费的exchange绑定在一起
    public Binding delayBinding() {
        return BindingBuilder.bind(delayQueue()).to(deadLetterExchange()).with(RabbitConst.QueueEnum.DELAY_QUEUE.getRoutingKeyName());
    }










//
//    // 创建一个立即消费队列
//    @Bean
//    public Queue immediateQueue() {
//        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
//        return new Queue(Constants.IMMEDIATE_QUEUE, true);
//    }
//
//    // 创建一个延时队列
//    @Bean
//    public Queue delayQueue() {
//        Map<String, Object> params = new HashMap<>();
//        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
//        params.put("x-dead-letter-exchange", Constants.IMMEDIATE_EXCHANGE);
//        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
//        params.put("x-dead-letter-routing-key", Constants.IMMEDIATE_ROUTING_KEY);
//        return new Queue(Constants.DELAY_QUEUE, true, false, false, params);
//    }
//
//    @Bean
//    public DirectExchange immediateExchange() {
//        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
//        //第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
//        return new DirectExchange(Constants.IMMEDIATE_EXCHANGE, true, false);
//    }
//
//    @Bean
//    public DirectExchange deadLetterExchange() {
//        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
//        //第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
//        return new DirectExchange(Constants.DEAD_LETTER_EXCHANGE, true, false);
//    }
//
//    @Bean
//    //把立即消费的队列和立即消费的exchange绑定在一起
//    public Binding immediateBinding() {
//        return BindingBuilder.bind(immediateQueue()).to(immediateExchange()).with(Constants.IMMEDIATE_ROUTING_KEY);
//    }
//
//    @Bean
//    //把立即消费的队列和立即消费的exchange绑定在一起
//    public Binding delayBinding() {
//        return BindingBuilder.bind(delayQueue()).to(deadLetterExchange()).with(Constants.DELAY_ROUTING_KEY);
//    }






}
