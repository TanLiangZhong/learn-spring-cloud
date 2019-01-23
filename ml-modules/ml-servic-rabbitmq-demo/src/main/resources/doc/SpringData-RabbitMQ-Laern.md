### [RabbitMQ Document](http://www.rabbitmq.com/)

###1. [docker-install-RabbitMQ](https://www.jianshu.com/p/14ffe0f3db94)

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
      host: localhost
      port: 5672
      username: user
      password: password
```
###4. add Provider
```java
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
```
###4. add Consumer
```java
@Component
public class DemoConsumer {

    final static String ML_MQ = "ML_MQ";

    /**
     * 处理 rabbitMQ 测试
     *
     * @param data
     */
    @RabbitListener(queues = ML_MQ)
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
欲知后事如何 且听我下回分说
