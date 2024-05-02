package org.javaacademy.bitcoinservice.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.bitcoinservice.config.FreeCurrencyProperties;
import org.javaacademy.bitcoinservice.dto.FreeCurrencyDtoRs;
import org.javaacademy.bitcoinservice.exception.IntegrationException;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FreeCurrencyIntegrationService {
    private static final String CURRENCY_NAME = "RUB";
    private static final String POSTFIX_URL_GET_RUB_TEMPLATE =
            String.format("latest?currencies=%s", CURRENCY_NAME);
    private final RestTemplate restTemplate;
    private final FreeCurrencyProperties properties;

    public FreeCurrencyDtoRs getFreeCurrencyDtoRs() {
        String postfixUrl = POSTFIX_URL_GET_RUB_TEMPLATE.formatted(CURRENCY_NAME);
        RequestEntity<Void> request = RequestEntity
                .get(properties.getBaseUrl() + postfixUrl)
                .header(properties.getHeadertokenname(), properties.getToken())
                .build();
        try {
            return restTemplate.exchange(request, FreeCurrencyDtoRs.class).getBody();
        } catch (Throwable throwable) {
            throw new IntegrationException();
        }
    }
}
