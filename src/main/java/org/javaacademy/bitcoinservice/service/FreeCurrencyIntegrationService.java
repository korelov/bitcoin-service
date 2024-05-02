package org.javaacademy.bitcoinservice.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.bitcoinservice.config.FreeCurrencyProperties;
import org.javaacademy.bitcoinservice.dto.BitcoinDtoRs;
import org.javaacademy.bitcoinservice.dto.FreeCurrencyDtoRs;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FreeCurrencyIntegrationService {
    private static final String CURRENCY_NAME = "RUB";
    private static final String POSTFIX_URL_GET_RUB_TEMPLATE = "/latest?base_currency=%s&currencies=%s";
    private final RestTemplate restTemplate;
    private final FreeCurrencyProperties freeCurrencyProperties;


    public BitcoinDtoRs convertCurrency(BigDecimal amountRub) {
        RequestEntity<Void> request = RequestEntity.get(freeCurrencyProperties.getBaseUrl() + "/latest?currencies=RUB")
                .header(freeCurrencyProperties.getHeadertokenname(), freeCurrencyProperties.getToken()).build();
        ResponseEntity<FreeCurrencyDtoRs> response = restTemplate.exchange(request, FreeCurrencyDtoRs.class);
        FreeCurrencyDtoRs freeCurrencyDtoRs = response.getBody();
        BigDecimal dollarRate = freeCurrencyDtoRs.getStringBigDecimalMap().get(CURRENCY_NAME);
        BigDecimal dollarAmount = amountRub.divide(dollarRate);
        return new BitcoinDtoRs("Dollar", dollarAmount, dollarRate);
    }

}
