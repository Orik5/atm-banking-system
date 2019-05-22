package com.example.demo.dto;


import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Integer userId;
    private String userName;
    private String password;
    private BigDecimal balance;
    private String mobilePhone;
    private String surname;
    private String middleName;
    private BigDecimal temporarySafeBalanceAfterGetting;

    public UserDto(Integer userId, String userName, String password, BigDecimal balance, String mobilePhone,
                   String surname, String middleName, BigDecimal temporarySafeBalanceAfterGetting) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.mobilePhone = mobilePhone;
        this.surname = surname;
        this.middleName = middleName;
        this.temporarySafeBalanceAfterGetting = temporarySafeBalanceAfterGetting;
    }

    public UserDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public BigDecimal getTemporarySafeBalanceAfterGetting() {
        return temporarySafeBalanceAfterGetting;
    }

    public void setTemporarySafeBalanceAfterGetting(BigDecimal temporarySafeBalanceAfterGetting) {
        this.temporarySafeBalanceAfterGetting = temporarySafeBalanceAfterGetting;
    }

    public static UserDto convertToDto(User user) {
        return new UserDto(user.getUserId(), user.getUserName(), user.getPassword(), user.getBalance(),
                user.getPassword(), user.getMobilePhone(), user.getMiddleName(), user
                .getTemporarySafeBalanceAfterGetting());

    }
}
