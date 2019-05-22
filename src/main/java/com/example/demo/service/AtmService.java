package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

public interface AtmService<E, K, T> {

    void saveOrUpdate(E entity);

    void findById(K id);

    void withdraw(E entity, T type);

    void putCashIntoAtm(E entity, T type);

    List<BigDecimal> getDenominations();


}
