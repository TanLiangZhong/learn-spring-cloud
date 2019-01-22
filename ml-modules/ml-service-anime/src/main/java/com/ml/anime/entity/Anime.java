package com.ml.anime.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 动漫 - Entity
 *
 * @author liangzhong
 * @date 2019-01-14 22:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "anime")
public class Anime implements Serializable {

/**
 * UUID 主键 ID
 *
 * @GeneratedValue(generator = "system-uuid")
 * @GenericGenerator(name = "system-uuid", strategy = "uuid")
 * <p>
 * 有数据库的自增列提供主键  ,  IDENTITY 与 AUTO 策略相同
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * <p>
 * @TableGenerator 标签的属性解释：
 */

    /**
     * @TableGenerator 标签的属性解释：
     * <p>
     * 1 allocationSize 属性需要赋一个整数值。表示了bucket的容量。其默认值为50。
     * 2 table 属性用于指定辅助表的表名。这里指定为t_id_generator数据表
     * <p>
     * 其基本思想就是：从table指定的辅助表中读取一个bucket段id号范围内的第一个数值，记为first_id。在后面持久化过程中的id号是从first_id开始依次递增1得到
     * 当递增到first_id + allocationSize 的时候，就会再一次从辅助表中读取一个first_id开始新一轮的id生成过程。
     * <p>
     * 我们知道，要从数据库中确定一个值，则必须确定其“行”和“列”。JPA自动产生的t_id_generator只有两列。当然，如果该表
     * 为n个表产生id，则会在t_id_generator表中保存“n行2列”。
     * 那么，如何从数据表t_id_generator中确定出seed_id用于为Customer实体计算id呢？？JPA会依据Customer实体的
     * @TableGenerator 属性值来依据下面的规则的到seed_id：
     * ③、valueColumnName 属性指定了seed_id的列名。valueColumnName="PK_VALUE"也就是指定了
     * seed_id位于PK_VALUE列中。同时，规定了这一列必须是数值型（int,long等）。
     * 剩下的任务就是如何从n行中确定出是哪一行？？
     * ④、pkColumnName="PK_NAME",pkColumnValue="seed_t_customer_id" 两个一起来确定具体的行：
     * 在PK_NAME列中，值为seed_t_customer_id的那一行。
     * ⑤、由上面③和④中确定出来的“行”和“列”就可以得到一个int型的整数值。这个值就是first_id。
     * <p>
     * 注意：我们的数据库中可以没有t_id_generator这张表，JPA会自动帮助我们完成该表的创建工作。自动创建的表只有两列：
     * PK_NAME(VARCHAR)和PK_VALUE(int)。同时会自动添加一条记录(seed_t_customer_id, 51) 依据优化策略的不同，辅助表中记录的数值有区别
     */
    @TableGenerator(
            name = "ID_GENERATOR",
            table = "sys_sequence",   // 主键表 表名
            pkColumnName = "seq_name", // 过滤条件列名
            pkColumnValue = "seq_anime",  //  过滤条件值. 通过 pkColumnName pkColumnValue 确定具体的行
            valueColumnName = "current_value", // 属性指定了seed_id的列名 ,  规定了这一列必须是数值型（int,long等）
            allocationSize = 20
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 描述
     */
    @Column(name = "description", length = -1)
    private String description;

    /**
     * Must be {@link Transient} in order to ensure that no JPA provider complains because of a missing setter.
     *
     * @see org.springframework.data.domain.Persistable#isNew()
     */
    @Transient // DATAJPA-622
    public boolean isNew() {
        return null == getId();
    }
}
