package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.exception.EmptyBallanceException;
import com.example.demo.exception.IncorrectUserNameException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;

@Service
public class UserService extends AbstractService<User, UserRepository> {

    @Autowired
    private UserRepository userRepository;

    protected UserService(UserRepository repository) {
        super(repository);
    }

    public void findByName(String name) {
        userRepository.getUserByUserName(name);
    }

    public void sendMoneyToAnotherUser(User user, BigDecimal money, HashSet<User> users, String myName, String username) throws IncorrectUserNameException, EmptyBallanceException {

        for (User person :
                users) {
            if (person.getUserName().equals(myName)) {
                userRepository.getUserByUserName(myName);
                for (User person2 : users
                ) {
                    if (person2.getUserName().equals(username)) {
                        userRepository.getUserByUserName(username);
                        if ((person.getBalance().intValue()) > 0 &&
                                person.setBalance(money).intValue() > 0) {
                            BigDecimal addPerson1 = person.setBalance(money).add(person2.getBalance());
                            BigDecimal substrPerson2 = person.getBalance().subtract(person.setBalance(money));
                            person2.setBalance(addPerson1);
                            person.setBalance(substrPerson2);
                            userRepository.setBalanceIntoUser(person2.getId(), person.setBalance(addPerson1));
                            userRepository.setBalanceIntoUser(person.getId(), person.setBalance(substrPerson2));
                        }
                        throw new EmptyBallanceException("Your balance is empty");
                    }

                }
            }

        }
    }
}
