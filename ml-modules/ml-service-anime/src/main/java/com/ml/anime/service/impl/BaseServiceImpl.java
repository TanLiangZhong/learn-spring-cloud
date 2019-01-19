package com.ml.anime.service.impl;

import com.ml.anime.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * 基础 - Service
 *
 * @author liangzhong
 * @date 2019/1/17 10:44
 */
public abstract class BaseServiceImpl<R extends PagingAndSortingRepository<T, ID>, T, ID> implements BaseService<T, ID> {

    @Autowired(required = false)
    protected R r;

    @Override
    public <S extends T> S save(S entity) {
        return r.save(entity);
    }

    @Override
    public Iterable<T> findAll() {
        return r.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return r.findById(id);
    }
}
