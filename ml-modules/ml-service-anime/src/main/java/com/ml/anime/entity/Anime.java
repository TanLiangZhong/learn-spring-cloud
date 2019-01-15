package com.ml.anime.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * 动漫 - Entity
 *
 * @author liangzhong
 * @date 2019-01-14 22:28
 */
@Entity
@Data
@Table(name = "anime")
@EqualsAndHashCode(callSuper = true)
public class Anime extends AbstractPersistable<Long> {

//    /**
//     * 主键
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    @Nullable
//    private Long id;


//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
//    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
//    private Long id;


    /**
     * 名称
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * 描述
     */
    @Basic
    @Column(name = "description", length = -1)
    private String description;

}
