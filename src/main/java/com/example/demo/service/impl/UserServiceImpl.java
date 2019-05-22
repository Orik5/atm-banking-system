package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.AtmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService<User, Integer, BigDecimal> {
    private final static ArrayList<BigDecimal> denominations = new ArrayList(Arrays.asList(100, 200, 500));


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AtmRepository atmRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void findById(Integer id) {
        userRepository.findById(id);
    }


    @Override
    public void sendMoneyToAnotherUser(User user, BigDecimal money) {

        BigDecimal currentBalance = user.getBalance();

        userRepository.findByUserName(user.getUserName());
        user.setTemporarySafeBalanceAfterGetting(money.subtract(currentBalance));


    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public void findByUserName(String name) {
        User user = new User();
        userRepository.findByUserName(user.getUserName());
    }
}
