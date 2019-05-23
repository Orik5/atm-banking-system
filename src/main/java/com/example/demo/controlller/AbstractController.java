package com.example.demo.controlller;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E, Integer, BigDecimal,String>>
        implements CommonController<E,Integer> {

    private final S service;
    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<E> findById(E entity, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<E> getAll(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> findByName(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> save(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> putCashIntoAtm(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> sendMoneyToAnotherUser(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> withdraw(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> update(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> delete(E entity, Integer id) {
        return null;
    }
}
