package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.exception.RangeNotSatisfiableException;

import java.util.List;

public interface CommonService<E extends AbstractEntity, K, T, N> {
    void create(E entity);

    void saveOrUpdate(E entity);

    void delete(K id);

    void findById(K id);

    void sendMoneyToAnotherUser(E entity, T type);

    void findByName(N value);

    void withdraw(E entity, T type) throws RangeNotSatisfiableException;

    void putCashIntoAtm(E entity, T type) throws RangeNotSatisfiableException;

    List<E> list();

    List<T> getDenominations();


}
