package com.example.demo.service;


import com.example.demo.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService<E, K, T> {

    void add(E entity);

    void saveOrUpdate(E entity);

    void delete(K id);

    void findById(K id);

    void sendMoneyToAnotherUser(E entity, T type);

    void findByUserName(String name);

    List<User> list();

}
