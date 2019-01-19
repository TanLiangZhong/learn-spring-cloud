package com.ml.anime.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
public class Anime extends BaseEntity {

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

}
