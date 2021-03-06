package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.Statement;

@Repository
public interface UserRepository extends CommonRepository<User, String> {
    @Query(value = "SELECT user_name FROM user WHERE user_name = ?", nativeQuery = true)
    String getUserByUserName(String name);

}
