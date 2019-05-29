package com.example.demo.repository;

import com.example.demo.domain.Atm;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AtmRepository extends CommonRepository<Atm, String> {
    @Modifying
    @Query(value = "UPDATE atm_banking_system.atm SET  balance =?  WHERE atm_id = ?", nativeQuery = true)
    void setBalanceIntoAtm(Integer id, BigDecimal money);
}
