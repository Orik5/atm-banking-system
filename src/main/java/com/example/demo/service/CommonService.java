package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.domain.User;

import java.math.BigDecimal;
import java.util.List;

public interface CommonService<E extends AbstractEntity, K, T,N> {
    void create(E entity);

    void saveOrUpdate(E entity);

    void delete(K id);

    void findById(K id);

    void sendMoneyToAnotherUser(E entity, T type);

    void findByName(N value);

    void withdraw(E entity, T type);

    void putCashIntoAtm(E entity, T type);

    List<E> list();

    List<T> getDenominations();


}
