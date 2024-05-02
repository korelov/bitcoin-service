package org.javaacademy.bitcoinservice.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.bitcoinservice.config.CoinDeskProperties;
import org.javaacademy.bitcoinservice.dto.CoindeskDtoRs;
import org.javaacademy.bitcoinservice.dto.FreeCurrencyDtoRs;
import org.javaacademy.bitcoinservice.exception.IntegrationException;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CoinDeskIntegrationService {
    private final RestTemplate restTemplate;
    private final CoinDeskProperties properties;

    public CoindeskDtoRs getCoindeskDtoRs() {
        RequestEntity<Void> request = RequestEntity
                .get(properties.getBaseUrl())
                .build();
        try {
            return restTemplate.exchange(request, CoindeskDtoRs.class).getBody();
        } catch (Throwable throwable) {
            throw new IntegrationException();
        }
    }
}
