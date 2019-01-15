package com.ml.anime.service.impl;

import com.ml.anime.repository.AnimeRepository;
import com.ml.anime.entity.Anime;
import com.ml.anime.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Anime save(Anime anime) {
        return animeRepository.save(anime);
    }

    @Override
    public Boolean update(Anime anime) {
//        return animeRepository.update(anime);
        return null;
    }

    @Override
    public Boolean delete(Long id) {
//        return animeRepository.delete(id);
        return null;
    }

    @Override
    public Anime findById(Long id) {
        return animeRepository.findById(id).orElse(new Anime());
    }

    @Override
    public List<Anime> findList(Anime anime) {
        // return animeRepository.findList(anime);
        return null;
    }

    @Override
    public List<Anime> findPage(Anime anime) {

        return null;
    }


}
