package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.repository.AtmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class UserService extends AbstractService<User, UserRepository> {

    @Autowired
    private UserRepository userRepository;


    protected UserService(UserRepository repository) {
        super(repository);
    }

    public void findByName(String entityname) {

        userRepository.findByName(entityname);

    }
    @Override
    public void sendMoneyToAnotherUser(User user, BigDecimal money) {

        BigDecimal currentBalance = user.getBalance();

        userRepository.findByName(user.getUserName());
        user.setTemporarySafeBalanceAfterGetting(money.subtract(currentBalance));
    }


}
