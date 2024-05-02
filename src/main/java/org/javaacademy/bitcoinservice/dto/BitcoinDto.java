package org.javaacademy.bitcoinservice.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class BitcoinDto {
    LocalDateTime requestTime;
    BigDecimal rublesCost;
}
