package com.ml.anime.service.impl;

import com.ml.anime.dao.AnimeRepository;
import com.ml.anime.service.AnimeService;
import com.ml.bean.anime.entity.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 动漫 - 服务实现
 *
 * @author liangzhong
 * @date 2019/1/14 13:51
 */
@Service
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public Boolean add(Anime anime) {
        return animeRepository.add(anime);
    }

    @Override
    public Boolean update(Anime anime) {
        return animeRepository.add(anime);
    }

    @Override
    public Boolean delete(Long id) {
        return animeRepository.delete(id);
    }

    @Override
    public Anime findById(Long id) {
        return  animeRepository.findById(id).orElse(new Anime());
    }

    @Override
    public List<Anime> findList(Anime anime) {
        return animeRepository.findList(anime);
    }
}
