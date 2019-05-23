package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User, String> {
    @Query(value = "SELECT user_name FROM user WHERE user_name = ?", nativeQuery = true)
    void findByName(String name);
}
