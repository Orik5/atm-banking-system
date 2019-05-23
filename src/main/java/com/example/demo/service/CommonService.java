package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.exception.RangeNotSatisfiableException;

import java.util.List;

public interface CommonService<E extends AbstractEntity, K, T, N> {
    void create(E entity);

    void saveOrUpdate(E entity);

    void delete(K id);

    void findById(K id);

    void findByName(N value);

    List<E> list();

    List<T> getDenominations();


}
