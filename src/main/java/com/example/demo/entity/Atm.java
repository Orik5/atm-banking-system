package com.example.demo.entity;

import com.example.demo.entity.Enum.ConvertBanknote;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "atm")
public class Atm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int atmId;
    private BigDecimal balance;

    public Atm() {
    }

    public Atm(BigDecimal balance) {
        this.balance = balance;
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }
}
