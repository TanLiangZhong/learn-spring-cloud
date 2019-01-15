package com.ml.anime.repository;

import com.ml.anime.entity.Anime;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author liangzhong
 * @date 2019/1/14 14:30
 */
public interface AnimeRepository extends PagingAndSortingRepository<Anime, Long> {

//    /**
//     * 新增
//     *
//     * @param anime
//     * @return success = true ,  fail = false
//     */
//    Boolean add(Anime anime);
//
//    /**
//     * 修改
//     *
//     * @param anime
//     * @return success = true ,  fail = false
//     */
//    Boolean update(Anime anime);
//
//    /**
//     * 删除
//     *
//     * @param id 主键
//     * @return success = true ,  fail = false
//     */
//    Boolean delete(Long id);
//
//    /**
//     * 查询列表
//     *
//     * @param anime 查询条件
//     * @return anime列表
//     */
//    List<Anime> findList(Anime anime);

}
