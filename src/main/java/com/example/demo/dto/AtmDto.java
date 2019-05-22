package com.example.demo.dto;

import com.example.demo.entity.Atm;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtmDto {
    private int atmId;
    private BigDecimal balance;

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AtmDto(int atmId, BigDecimal balance) {
        this.atmId = atmId;
        this.balance = balance;
    }

    public AtmDto() {
    }

    public static AtmDto convertToDto(Atm atm) {
        return new AtmDto(atm.getAtmId(), atm.getBalance());

    }
}
