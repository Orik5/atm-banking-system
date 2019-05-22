package com.example.demo.service.impl;

import com.example.demo.entity.Atm;
import com.example.demo.entity.User;
import com.example.demo.repository.AtmRepository;
import com.example.demo.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AtmServiceImpl implements AtmService<Atm, Integer, BigDecimal> {
    private final static ArrayList<BigDecimal> denominations = new ArrayList(Arrays.asList(100, 200, 500));


    @Autowired
    private AtmRepository atmRepository;


    private User user;


    @Override
    public void saveOrUpdate(Atm entity) {
        atmRepository.save(entity);

    }



    @Override
    public void findById(Integer id) {
        atmRepository.findById(id);
    }

    @Override
    public void withdraw(Atm atm, BigDecimal money) {

        List<BigDecimal> denominations = getDenominations();
        for (BigDecimal currentDenomination : denominations) {
            if ((atm.getBalance().intValue() > user.setBalance(money).intValue()) &&
                    user.setBalance(money).intValue() % currentDenomination.intValue() == 0) {
                BigDecimal substr = atm.getBalance().subtract(user.setBalance(money));
                BigDecimal s = user.getBalance().add(substr);
                user.setBalance(s);
            }
        }

    }


    @Override
    public List<BigDecimal> getDenominations() {
        return denominations;
    }

    @Override
    public void putCashIntoAtm(Atm atm, BigDecimal money) {
        List<BigDecimal> denominations = getDenominations();
        for (BigDecimal currentDenomination : denominations) {
            if ((atm.setBalance(money).intValue() > atm.getBalance().intValue()) &&
                    atm.setBalance(money).intValue() % currentDenomination.intValue() == 0) {
                BigDecimal substr = user.getBalance().subtract(atm.setBalance(money));
                BigDecimal s = atm.getBalance().add(substr);
                atm.setBalance(s);
            }
        }
    }
}



