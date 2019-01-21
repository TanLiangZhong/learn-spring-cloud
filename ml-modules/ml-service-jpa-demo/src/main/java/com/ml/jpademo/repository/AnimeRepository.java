package com.ml.jpademo.repository;

import com.ml.jpademo.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liangzhong
 * @date 2019/1/14 14:30
 */
@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
