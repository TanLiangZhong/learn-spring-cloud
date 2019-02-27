### [RabbitMQ Document](http://www.rabbitmq.com/)

###1. [docker-install-RabbitMQ](https://hub.docker.com/_/rabbitmq)
```
1. docker pull rabbitmq:3.7.8-management
2. docker run -d --name ml-rabbit -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password -p 5672:5672 -p 15672:15672 rabbitmq:3.7.8-management
3. 访问管理界面 `http://127.0.0.1:15672` (注:只有`management`版才有管理界面)
```
###2. add Depending
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```
###3. add Config
```yaml
spring:
    # rabbitmq 消息队列配置
    rabbitmq:
      host: 127.0.0.1
      port: 5672
      username: user
      password: password
```
###4. add Provider
```java
package com.ml.rabbitmq.service;

import com.ml.rabbitmq.constant.RabbitConst;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Demo - 提供者
 *
 * @author liangzhong
 * @date 2019/1/23 13:58
 */
@Service
public class DemoProvider {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public DemoProvider(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String data) {
        final int length = 100;
        for (int i = 0; i < length; i++) {
            // 发送
            rabbitTemplate.convertAndSend(RabbitConst.QueueEnum.ML_MQ.getQueueName(), data + " --- " + i);
        }
    }
}

```
###4. add Consumer
```java
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

```
###5. add Queues
```java
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
```
