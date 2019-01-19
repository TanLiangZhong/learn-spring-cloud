package com.ml.base.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author liangzhong
 * @date 2019/1/17 11:54
 */
@Data
@MappedSuperclass
abstract class BaseEntity extends AbstractPersistable<Long> implements Serializable {

    //abstract class BaseEntity extends AbstractPersistable<Long> implements Serializable {


    /**l
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}
