package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User extends AbstractEntity {

    private String userName;
    private String password;
    private BigDecimal balance;
    private String mobilePhone;
    private String surname;
    private String middleName;
    private BigDecimal temporarySafeBalanceAfterGetting;

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }


}
