package com.example.demo.entity.Enum;

import java.math.BigDecimal;

public enum ConvertBanknote {

    ONE_HUNDRED(new BigDecimal(100)),
    TWO_HUNDRED(new BigDecimal(200)),
    FIVE_HUNDRED(new BigDecimal(500)),;
    private BigDecimal value;

    ConvertBanknote(BigDecimal amount) {
        value = amount;
    }

    public BigDecimal value() {
        return value;
    }
}
