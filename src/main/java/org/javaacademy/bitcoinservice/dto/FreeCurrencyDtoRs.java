package org.javaacademy.bitcoinservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class FreeCurrencyDtoRs {
    private Map<String, BigDecimal> stringBigDecimalMap;


}
