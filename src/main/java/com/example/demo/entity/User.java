package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    private BigDecimal balance;
    private String mobilePhone;
    private String surname;
    private String middleName;
    private BigDecimal temporarySafeBalanceAfterGetting;


    public User(String userName, String password, BigDecimal balance,
                String mobilePhone, String surname, String middleName,
                BigDecimal temporarySafeBalanceAfterGetting) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.mobilePhone = mobilePhone;
        this.surname = surname;
        this.middleName = middleName;
        this.temporarySafeBalanceAfterGetting = temporarySafeBalanceAfterGetting;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }

    public BigDecimal getTemporarySafeBalanceAfterGetting() {
        return temporarySafeBalanceAfterGetting;
    }

    public void setTemporarySafeBalanceAfterGetting(BigDecimal temporarySafeBalanceAfterGetting) {
        this.temporarySafeBalanceAfterGetting = temporarySafeBalanceAfterGetting;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
