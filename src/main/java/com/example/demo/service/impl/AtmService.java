package com.example.demo.service.impl;

import com.example.demo.domain.Atm;
import com.example.demo.domain.User;
import com.example.demo.exception.EmptyBallanceException;
import com.example.demo.exception.IncorrectUserNameException;
import com.example.demo.exception.RangeNotSatisfiableException;
import com.example.demo.repository.AtmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.HashSet;
import java.util.List;

@Service
public class AtmService extends AbstractService<Atm, AtmRepository> {
    @Autowired
    // @Qualifier("atmRepository")
            AtmRepository atmRepository;
    @Autowired
    // @Qualifier("userRepository")
            UserRepository userRepository;

    protected AtmService(AtmRepository repository) {
        super(repository);
    }

    public void withdraw(Atm atm, BigDecimal money, HashSet<User> users, String name) throws RangeNotSatisfiableException, IncorrectUserNameException {
        users = new HashSet<>(userRepository.findAll());
        for (User person :
                users) {
            if (person.getUserName().equals(name)) {
                List<BigDecimal> denominations = getDenominations();
                for (BigDecimal currentDenomination : denominations) {
                    if ((atm.getBalance().intValue() > person.setBalance(money).intValue()) &&
                            person.setBalance(money).intValue() % currentDenomination.intValue() == 0) {
                        BigDecimal substr = atm.getBalance().subtract(person.setBalance(money));
                        atmRepository.setBalanceIntoAtm(atm.getId(), atm.setBalance(substr));

                    }
                    throw new RangeNotSatisfiableException("Incorrect amount requested");
                }
            }
        }
    }


    public void putCashIntoAtm(Atm atm, BigDecimal money, HashSet<User> users, String name) throws RangeNotSatisfiableException, IncorrectUserNameException, EmptyBallanceException {
        atm = atmRepository.getOne(1);
        users = new HashSet<>(userRepository.findAll());
        for (User person :
                users) {
            if (person.getUserName().equals(name)) {
                List<BigDecimal> denominations = getDenominations();
                for (BigDecimal currentDenomination : denominations) {
                    if ((person.setBalance(money).intValue()) > 0 &&
                            person.setBalance(money).intValue() % currentDenomination.intValue() == 0) {
                        BigDecimal substrAtm = atm.getBalance().add(person.setBalance(money));
                        BigDecimal substrUser = person.getBalance().subtract(person.setBalance(money));
                        person.setBalance(substrUser);
                        atmRepository.setBalanceIntoAtm(atm.getId(), atm.setBalance(substrAtm));
                    }
                    throw new EmptyBallanceException("Your balance is empty");

                }
                throw new RangeNotSatisfiableException("Incorrect amount requested");
            }
            throw new IncorrectUserNameException("Incorrect user name, please insert valid name");
        }
    }
}



