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
                atm.setBalance(substr);
            }
            throw new RangeNotSatisfiableException("Incorrect amount requested");
        }
    }


    public void putCashIntoAtm(Atm atm, BigDecimal money) throws RangeNotSatisfiableException {
        List<BigDecimal> denominations = getDenominations();
        for (BigDecimal currentDenomination : denominations) {
            if ((user.setBalance(money).intValue()) > 0 &&
                    user.setBalance(money).intValue() % currentDenomination.intValue() == 0) {
                BigDecimal substrAtm = atm.getBalance().add(user.setBalance(money));
                BigDecimal substrUser = user.getBalance().subtract(user.setBalance(money));
                user.setBalance(substrUser);
                atm.setBalance(substrAtm);
            }

            throw new RangeNotSatisfiableException("Incorrect amount requested");
        }
    }
}



