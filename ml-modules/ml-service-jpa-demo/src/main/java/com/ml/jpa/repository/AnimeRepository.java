package com.ml.jpa.repository;

import com.ml.jpa.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liangzhong
 * @date 2019/1/14 14:30
 */
@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
