package com.example.demo.repository;

import com.example.demo.domain.Atm;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository extends CommonRepository<Atm,String> {

}
