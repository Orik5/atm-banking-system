package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atm")
public class Atm extends AbstractEntity {

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }
}
