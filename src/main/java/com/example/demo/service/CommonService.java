package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.exception.RangeNotSatisfiableException;

import java.util.List;

public interface CommonService<E extends AbstractEntity, K, T, N> {
    E create(E entity);

    E saveOrUpdate(E entity);

    void delete(E entity);

    void findById(K id);

    void findByName(N value);

    List<E> list();

    List<T> getDenominations();


}
