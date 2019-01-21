### [Spring Data JPA Document](https://spring.io/projects/spring-data-jpa)
### 1. add Depending
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
### 2. add Entity
```java
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity // 用于注明该类是一个实体类
@Table(name = "anime") //表明该实体类映射到数据库的 t_customer 表
public class Anime extends BaseEntity {

    /**
     * UUID 主键 ID
     * @GeneratedValue(generator = "system-uuid")
     * @GenericGenerator(name = "system-uuid", strategy = "uuid")
     * <p>
     * 有数据库的自增列提供主键  ,  IDENTITY 与 AUTO 策略相同
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * <p>
     */
    @TableGenerator(
            name = "ID_GENERATOR",
            table = "sys_sequence",   // 主键表 表名
            pkColumnName = "seq_name", // 过滤条件列名
            pkColumnValue = "seq_anime",  //  过滤条件值. 通过 pkColumnName pkColumnValue 确定具体的行
            valueColumnName = "current_value", // 属性指定了seed_id的列名 ,  规定了这一列必须是数值型（int,long等）
            allocationSize = 17,  // 属性需要赋一个整数值。表示了bucket的容量。其默认值为50
            initialValue = 1       //初始值
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = -1)
    private String description;

}
```
> JPA主键生策略 `AUTO` `IDENTITY` `SEQUENCE` `TABLE`，
>  推荐使用 `TABLE` 主键生成策略。它是在不影响性能情况下，通用性最强的JPA主键生策略

### 3. add Repostiory
```java

```