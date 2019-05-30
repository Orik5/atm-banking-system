package com.example.demo.service.impl;

import com.example.demo.controlller.UserController;
import com.example.demo.domain.Atm;
import com.example.demo.domain.User;
import com.example.demo.exception.EmptyBallanceException;
import com.example.demo.exception.IncorrectUserNameException;
import com.example.demo.exception.RangeNotSatisfiableException;
import com.example.demo.repository.AtmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AbstractService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class AtmService extends AbstractService<Atm, AtmRepository> {
    final static Logger logger = Logger.getLogger(AtmService.class);
    @Autowired
    AtmRepository atmRepository;
    @Autowired
    UserRepository userRepository;

    protected AtmService(AtmRepository repository) {
        super(repository);
    }

    @Transactional
    public void withdraw(HashSet<Atm> atms, BigDecimal money, HashSet<User> users, String name) throws RangeNotSatisfiableException, IncorrectUserNameException {
        users = new HashSet<>(userRepository.findAll());
        atms = new HashSet<>(atmRepository.findAll());
        for (Atm atm : atms) {
            for (User person :
                    users) {
                if (person.getUserName().equals(name)) {
                    List<BigDecimal> denominations = getDenominations();
                    for (BigDecimal currentDenomination : denominations) {
                        if (atm.getBalance().compareTo(money) == 1 && isSuitableDenominationsAvailable(money, currentDenomination)) {
                            BigDecimal substr = atm.getBalance().subtract(money);
                            BigDecimal addPerson1 = person.getBalance().add(money);
                            atm.setBalance(substr);
                            person.setBalance(addPerson1);
                            break;
                        } else {
                            throw new RangeNotSatisfiableException("Incorrect amount requested");
                        }
                    }
                }
            }
        }
    }

    private static boolean isSuitableDenominationsAvailable(BigDecimal money, BigDecimal currentDenominations) throws RangeNotSatisfiableException {
        money.remainder(currentDenominations);
        return true;

    }

    @Transactional
    public void putCashIntoAtm(HashSet<Atm> atms, BigDecimal money, HashSet<User> users, String name) throws RangeNotSatisfiableException, IncorrectUserNameException, EmptyBallanceException {
        atms = new HashSet<>(atmRepository.findAll());
        users = new HashSet<>(userRepository.findAll());
        for (Atm atm : atms) {
            for (User person :
                    users) {
                if (person.getUserName().equals(name)) {
                    List<BigDecimal> denominations = getDenominations();
                    for (BigDecimal currentDenomination : denominations) {
                        if (person.getBalance().compareTo(money) == 1 && isSuitableDenominationsAvailable(money, currentDenomination)) {
                            BigDecimal addAtm = atm.getBalance().add(money);
                            BigDecimal substrUser = person.getBalance().subtract(money);
                            atm.setBalance(addAtm);
                            person.setBalance(substrUser);
                            break;

                        } else {
                            throw new EmptyBallanceException("Your balance is empty");
                        }
                    }


                }
            }

        }
    }
}



