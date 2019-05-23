package com.example.demo.dto;

import com.example.demo.domain.Atm;
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
public class AtmDto {
    private Integer atmId;
    private BigDecimal balance;

    public static AtmDto convertToDto(Atm atm) {
        return new AtmDto(atm.getId(), atm.getBalance());

    }
}
