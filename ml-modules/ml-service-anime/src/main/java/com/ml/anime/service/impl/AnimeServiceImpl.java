package com.ml.anime.service.impl;

import com.alibaba.fastjson.JSON;
import com.ml.anime.entity.Anime;
import com.ml.anime.repository.AnimeRepository;
import com.ml.bean.anime.bo.AnimeBo;
import com.ml.bean.anime.vo.AnimeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 动漫 - 服务实现
 *
 * @author liangzhong
 * @date 2019/1/14 13:51
 */
@Slf4j
@Service
public class AnimeServiceImpl extends BaseServiceImpl<AnimeRepository, Anime, Long> {

    public List<AnimeVo> findAllVo() {
        Iterable<Anime> iterable = this.findAll();
        List<AnimeVo> vos = new ArrayList<>();
        iterable.forEach(i -> {
            AnimeVo vo = new AnimeVo();
            BeanUtils.copyProperties(i, vo);
            vos.add(vo);
        });
        return vos;
    }

    public Anime save(AnimeBo bo) {
        Anime entity = new Anime();

        log.info(" bo ", bo.toString());

        BeanUtils.copyProperties(bo, entity);

        log.info(" entity ", entity.toString());

        return this.save(entity);
    }

}
