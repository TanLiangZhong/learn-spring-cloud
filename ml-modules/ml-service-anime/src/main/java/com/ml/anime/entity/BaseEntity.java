package com.ml.anime.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author liangzhong
 * @date 2019/1/17 11:54
 */
//abstract class BaseEntity extends AbstractPersistable<Long> implements Serializable {

abstract class BaseEntity implements Serializable {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

}
