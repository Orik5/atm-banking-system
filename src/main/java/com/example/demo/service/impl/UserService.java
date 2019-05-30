package com.example.demo.service.impl;

import com.example.demo.controlller.ExceptionHandlerController;
import com.example.demo.domain.User;
import com.example.demo.exception.EmptyBallanceException;
import com.example.demo.exception.IncorrectUserNameException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AbstractService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Statement;
import java.util.HashSet;

@Service
public class UserService extends AbstractService<User, UserRepository> {
    final static Logger logger = Logger.getLogger(ExceptionHandlerController.class);
    @Autowired
    private UserRepository userRepository;

    protected UserService(UserRepository repository) {
        super(repository);
    }


    public void findByName(String name) {
        userRepository.getUserByUserName(name);
    }

    @Transactional
    public void sendMoneyToAnotherUser(User user, BigDecimal money, HashSet<User> users, String myName, String username) throws IncorrectUserNameException, EmptyBallanceException {
        users = new HashSet<>(userRepository.findAll());
        logger.debug(users);
        for (User person :
                users) {
            if (person.getUserName().equals(myName)) {
                userRepository.getUserByUserName(myName);
                for (User person2 : users) {
                    if (person2.getUserName().equals(username)) {
                        userRepository.getUserByUserName(username);
                        if ((person.getBalance().compareTo(money) > 0)) {
                            BigDecimal addPerson1 = person2.getBalance().add(money);
                            BigDecimal substrPerson2 = person.getBalance().subtract(money);
                            person2.setBalance(addPerson1);
                            person.setBalance(substrPerson2);
                            logger.debug(person2.getBalance());
                            logger.debug(person.getBalance());
                        } else {
                            throw new EmptyBallanceException("Your balance is empty");
                        }

                    }

                }
            }

        }
    }
}
