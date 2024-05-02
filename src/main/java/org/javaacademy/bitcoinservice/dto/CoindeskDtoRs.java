package org.javaacademy.bitcoinservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CoindeskDtoRs {
    private Bpi bpi;

    public static class Bpi {
        @JsonProperty("USD")
        public USD usd;

        public static class USD {
            public String code;
            public String symbol;
            public String rate;
            public String description;
            public BigDecimal rate_float;
        }
    }
}
