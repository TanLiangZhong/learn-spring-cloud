package com.ml.anime.service;

import java.util.Optional;

/**
 * 基础 - Service
 *
 * @author liangzhong
 * @date 2019/1/17 10:44
 */
public interface BaseService<T, ID> {

    /**
     * 保存
     * <p>
     * isNew = true  add
     * isNew = false update
     * </p>
     *
     * @param entity
     * @param <S>
     * @return Entity
     */
    <S extends T> S save(S entity);

    /**
     * 根据Id查询
     *
     * @param id
     * @return Optional
     */
    Optional<T> findById(ID id);

    /**
     * 查询所有
     *
     * @return Iterable
     */
    Iterable<T> findAll();
}
