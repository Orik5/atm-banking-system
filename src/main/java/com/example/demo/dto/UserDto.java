package com.example.demo.dto;


import com.example.demo.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public static void convertToDto(User user) {
        new UserDto(user.getId(), user.getUserName(), user.getPassword(), user.getBalance(),
                user.getPassword(), user.getMobilePhone(), user.getMiddleName(), user
                .getTemporarySafeBalanceAfterGetting());

    }
}
