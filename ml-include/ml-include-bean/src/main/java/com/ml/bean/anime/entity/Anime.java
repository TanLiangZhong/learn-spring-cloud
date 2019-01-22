package com.ml.bean.anime.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 动漫 - Entity
 *
 * @author liangzhong
 * @date 2019-01-14 22:28
 */
@Data
public class Anime implements Serializable {

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

    public Anime() {
    }

    public Anime(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static List<Anime> getParam() {
        List<Anime> list = new ArrayList<>();
        list.add(new Anime("东方月初", "狐妖小红娘"));
        list.add(new Anime("涂山红红", "狐妖小红娘"));
        list.add(new Anime("上条当麻", "科学超电磁炮"));
        list.add(new Anime("御坂美琴", "科学超电磁炮"));
        list.add(new Anime("雷姆", "从零开始的异世界生活"));
        return list;
    }
}
