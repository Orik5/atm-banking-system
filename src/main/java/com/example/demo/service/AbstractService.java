package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.domain.User;
import com.example.demo.exception.RangeNotSatisfiableException;
import com.example.demo.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E, String>>
        implements CommonService<E, Integer, BigDecimal, String> {

    protected final R repository;

    private final static ArrayList<BigDecimal> denominations = new ArrayList(Arrays.asList(new BigDecimal("100"),
            new BigDecimal("200"), new BigDecimal("500")));

    protected AbstractService(R repository) {
        this.repository = repository;
    }


    @PersistenceContext(name = "footprint")
    protected transient EntityManager manager;

    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    @Override
    public E saveOrUpdate(E entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(E entity) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException {
        repository.delete(entity);
    }

    @Override
    public void findById(Integer id) {
        repository.findById(id);
    }

    @Override
    public void findByName(String name) {
    }

    @Override
    public List<E> list() {

        return repository.findAll();
    }


    @Override
    public List<BigDecimal> getDenominations() {
        return denominations;
    }


}
