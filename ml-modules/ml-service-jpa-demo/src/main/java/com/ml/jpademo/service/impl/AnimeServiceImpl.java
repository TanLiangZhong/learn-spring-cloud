package com.ml.jpademo.service.impl;

import com.alibaba.fastjson.JSON;
import com.ml.base.service.impl.BaseServiceImpl;
import com.ml.bean.anime.bo.AnimeBo;
import com.ml.bean.anime.vo.AnimeVo;
import com.ml.jpademo.entity.Anime;
import com.ml.jpademo.entity.PageBo;
import com.ml.jpademo.repository.AnimeRepository;
import com.ml.jpademo.service.AnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 动漫 - 服务实现
 *
 * @author liangzhong
 * @date 2019/1/14 13:51
 */
@Slf4j
@Service
public class AnimeServiceImpl extends BaseServiceImpl<AnimeRepository, Anime, Long> implements AnimeService<Anime, Long> {

    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> getParam() {
        List<Anime> list = new ArrayList<>();
        list.add(new Anime("桐谷和人", "刀剑神域"));
        list.add(new Anime("结城明日奈", "刀剑神域"));
        list.add(new Anime("立华奏", "Angel Beats"));
        list.add(new Anime("音无", "Angel Beats"));
        list.add(new Anime("漩涡鸣人", "火影忍者"));
        list.add(new Anime("日向雏田", "火影忍者"));
        list.add(new Anime("楪祈", "罪恶王冠"));
        list.add(new Anime("樱满集", "罪恶王冠"));
        list.add(new Anime("绯", "野良神"));
        list.add(new Anime("夜斗", "野良神"));
        list.add(new Anime("东方月初", "狐妖小红娘"));
        list.add(new Anime("涂山红红", "狐妖小红娘"));
        list.add(new Anime("立花泷", "你的名字"));
        list.add(new Anime("宫水三叶", "你的名字"));
        list.add(new Anime("蒙奇·D·路飞", "海贼王"));
        list.add(new Anime("罗罗诺亚·索隆", "海贼王"));
        list.add(new Anime("上条当麻", "科学超电磁炮"));
        list.add(new Anime("御坂美琴", "科学超电磁炮"));
        list.add(new Anime("雷姆", "从零开始的异世界生活"));
        list.add(new Anime("拉姆", "从零开始的异世界生活"));
        return list;
    }

    /**
     * 保存
     *
     * @param bo
     * @return
     */
    public void save(AnimeBo bo) {

//        list.forEach(e -> animeRepository.save(e));

        animeRepository.saveAll(getParam());

//        Anime e = new Anime();
//        BeanUtils.copyProperties(bo, e);
//        animeRepository.save(e);
    }


    /**
     * 查询所有
     *
     * @return
     */
    public List<AnimeVo> findAllVo() {
        List<AnimeVo> list = new ArrayList<>();
        this.findAll().forEach(i -> {
            AnimeVo e = new AnimeVo();
            BeanUtils.copyProperties(i, e);
            list.add(e);
        });
        return list;
    }

    /**
     * 分页
     *
     * @param pageBo
     * @return
     */
    public Page<Anime> findPage(PageBo<AnimeBo> pageBo) {
        PageRequest pageRequest = PageRequest.of(pageBo.getPage(), pageBo.getSize());
        Page<Anime> page = animeRepository.findAll(pageRequest);
        return page;
    }



}

