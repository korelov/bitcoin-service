package org.javaacademy.bitcoinservice.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class BitcoinDtoRs {
    String CurrencyName;
    BigDecimal amount;
    BigDecimal rate;
}
