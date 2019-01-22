### [Spring Data Redis Document](https://spring.io/projects/spring-data-redis)
### 1. add Depending
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
### 2. add Config
```yaml
spring:
 # redis 配置
  redis:
    # 数据库索引 (default:0)
    database: 0
    # 服务器地址 (default:localhost)
    host: 192.168.131.164
    # 服务器连接端口 (default:6379)
    port: 6379
    # 服务器连接密码 (default:空)
    password: kirito1117
    jedis:
      pool:
        # 连接池最大连接数 (default:8 , 使用负值表示没有限制)
        max-active: 8
        # 连接池最大阻塞等待时间 (default: -1 , 使用负值表示没有限制)
        max-wait: -1
        # 连接池中的最大空闲连接 (default:8)
        max-idle: 8
        # 连接池中的最小空闲连接 (default:0)
        min-idle: 0
    # 连接超时时间 (毫秒)
    timeout: 500
```
### 3. [RedisTemplate](https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/core/RedisTemplate.html) Use
```java
public class RedisController {

    @Autowired(required = false)
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation("Set Value")
    @GetMapping("set")
    public void setValue(@ApiParam(value = "键", required = true) @RequestParam String key, @ApiParam(value = "值", required = true) @RequestParam String val) {
        // -----------------基础数据 类型数据操作 start--------------------
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        // String类型数据存储，不设置过期时间，永久性保存
        valueOperations.set(key, val);
        // String类型数据存储，设置过期时间为80秒，采用TimeUnit控制时间单位
        valueOperations.set(key + "_Time", val + "Time", 77, TimeUnit.SECONDS);
        // 判断key值是否存在，存在则不存储，不存在则存储
        valueOperations.setIfAbsent(key, val + "My_Redis");
        valueOperations.setIfAbsent(key + "1", "My_Redis_111");
    }

    @ApiOperation("Get Value")
    @GetMapping("get/{key}")
    public Object getValue(@ApiParam(value = "键", required = true) @PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @ApiOperation("Remove Value")
    @DeleteMapping("remove/{key}")
    public Object removeValue(@ApiParam(value = "键", required = true) @PathVariable String key) {
        return redisTemplate.delete(key);
    }
}
```