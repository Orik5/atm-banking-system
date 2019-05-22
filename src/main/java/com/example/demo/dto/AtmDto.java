package com.example.demo.dto;

import com.example.demo.entity.Atm;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtmDto {
    private int atmId;
    private BigDecimal balance;


    public static AtmDto convertToDto(Atm atm) {
        return new AtmDto(atm.getAtmId(), atm.getBalance());

    }
}
