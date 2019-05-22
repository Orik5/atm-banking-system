package com.example.demo.entity;

import com.example.demo.entity.Enum.ConvertBanknote;
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
public class Atm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int atmId;
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }
}
