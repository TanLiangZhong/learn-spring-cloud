package com.ml.bean.anime.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 动漫 - Entity
 *
 * @author liangzhong
 * @date 2019-01-14 22:28
 */
@Data
public class Anime implements Serializable {

    private static final long serialVersionUID = 4581695118559695968L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

}
