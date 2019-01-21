package com.ml.jpademo.service.impl;

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
    public void save(AnimeBo bo) {
        Anime e = new Anime();
        BeanUtils.copyProperties(bo, e);
        animeRepository.save(e);
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
