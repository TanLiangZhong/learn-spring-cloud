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
        list.add(new Anime("佩恩", "和平"));
        list.add(new Anime("迪达拉", "艺术"));
        list.add(new Anime("小南", "友情"));
        list.add(new Anime("鼬", "亲情"));
        list.add(new Anime("绝", "统治"));
        list.add(new Anime("带土", "爱情"));
        list.add(new Anime("鬼鲛", "力量"));
        list.add(new Anime("角都", "金钱"));
        list.add(new Anime("飞段", "宗教"));
        list.add(new Anime("蝎", "童年"));
        list.add(new Anime("自来也", "黄"));
        list.add(new Anime("大蛇丸", "毒"));
        list.add(new Anime("纲手", "赌"));

        list.add(new Anime("自来也", "1"));
        list.add(new Anime("大蛇丸", "1"));
        list.add(new Anime("纲手", "1"));
        list.add(new Anime("自来也", "2"));
        list.add(new Anime("大蛇丸", "2"));
        list.add(new Anime("纲手", "2"));
        return list;
    }
}
