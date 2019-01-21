package com.ml.anime.service.impl;

import com.ml.anime.entity.Anime;
import com.ml.anime.repository.AnimeRepository;
import com.ml.anime.service.AnimeService;
import com.ml.base.service.impl.BaseServiceImpl;
import com.ml.bean.anime.bo.AnimeBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 保存
     *
     * @param bo
     * @return
     */
    public boolean save(AnimeBo bo) {
        Anime e = new Anime();
        BeanUtils.copyProperties(bo, e);
        animeRepository.save(e);
        return true;
    }

}
