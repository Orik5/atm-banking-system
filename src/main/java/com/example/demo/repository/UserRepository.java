package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public interface UserRepository extends CommonRepository<User, String> {
    @Query(value = "SELECT user_name FROM user WHERE user_name = ?", nativeQuery = true)
    String getUserByUserName(String name);

    @Query(value = "UPDATE atm_banking_system.user SET  balance =?  WHERE user_id = ?", nativeQuery = true)
    void setBalanceIntoUser(Integer id, BigDecimal money);

}
