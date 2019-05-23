package com.example.demo.service.impl;

import com.example.demo.domain.Atm;
import com.example.demo.domain.User;
import com.example.demo.exception.RangeNotSatisfiableException;
import com.example.demo.repository.AtmRepository;
import com.example.demo.service.AbstractService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;

@Service
public class AtmService extends AbstractService<Atm, AtmRepository> {

    private User user;

    protected AtmService(AtmRepository repository) {
        super(repository);
    }

    public void withdraw(Atm atm, BigDecimal money) throws RangeNotSatisfiableException {

        List<BigDecimal> denominations = getDenominations();
        for (BigDecimal currentDenomination : denominations) {
            if ((atm.getBalance().intValue() > user.setBalance(money).intValue()) &&
                    user.setBalance(money).intValue() % currentDenomination.intValue() == 0) {
                BigDecimal substr = atm.getBalance().subtract(user.setBalance(money));
                BigDecimal s = user.getBalance().add(substr);
                user.setBalance(s);
            }
            throw new RangeNotSatisfiableException("Incorrect amount requested");
        }
    }


    public void putCashIntoAtm(Atm atm, BigDecimal money) throws RangeNotSatisfiableException {
        List<BigDecimal> denominations = getDenominations();
        for (BigDecimal currentDenomination : denominations) {
            if ((atm.setBalance(money).compareTo(atm.getBalance()) > atm.getBalance().intValue()) &&
                    atm.setBalance(money).intValue() % currentDenomination.intValue() == 0) {
                BigDecimal substr = user.getBalance().subtract(atm.setBalance(money));
                BigDecimal s = atm.getBalance().add(substr);
                atm.setBalance(s);
            }
            throw new RangeNotSatisfiableException("Incorrect amount requested");
        }
    }
}



