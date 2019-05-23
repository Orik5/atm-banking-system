package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.repository.AtmRepository;
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

    public void findByName(String entity) {
        userRepository.findByName(entity);
    }

    public void sendMoneyToAnotherUser(BigDecimal money, HashSet<User> users, String myName, String username) {
        for (User person :
                users) {
            if (person.getUserName().equals(myName)) {
                for (User person2 : users
                ) {
                    if (person2.getUserName().equals(username)) {
                        if ((person.getBalance().intValue()) > 0 &&
                                person.setBalance(money).intValue() > 0) {
                            BigDecimal addPerson1 = person.setBalance(money).add(person2.getBalance());
                            BigDecimal substrPerson2 = person.getBalance().subtract(person.setBalance(money));
                            person2.setBalance(addPerson1);
                            person.setBalance(substrPerson2);
                        }

                    }
                }
            }
        }
    }
}
