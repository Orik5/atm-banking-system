package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.domain.User;
import com.example.demo.exception.RangeNotSatisfiableException;
import com.example.demo.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E, String>>
        implements CommonService<E, Integer, BigDecimal, String> {
    protected final R repository;
    private final static ArrayList<BigDecimal> denominations = new ArrayList(Arrays.asList(100, 200, 500));

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public void create(E entity) {
        repository.save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void findById(Integer id) {
        repository.findById(id);
    }

    @Override
    public void sendMoneyToAnotherUser(E entity, BigDecimal type) {

    }

    @Override
    public void findByName(String entity) {
    }

    @Override
    public List<E> list() {
        return repository.findAll();
    }

    @Override
    public void withdraw(E entity, BigDecimal type) throws RangeNotSatisfiableException {

    }

    @Override
    public void putCashIntoAtm(E entity, BigDecimal type) throws RangeNotSatisfiableException {

    }

    @Override
    public List<BigDecimal> getDenominations() {
        return denominations;
    }


}
