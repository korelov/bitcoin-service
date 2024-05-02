package org.javaacademy.bitcoinservice.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class BitcoinDtoRq {
    String toCurrencyName;   // rub
    BigDecimal amountRub;
}
