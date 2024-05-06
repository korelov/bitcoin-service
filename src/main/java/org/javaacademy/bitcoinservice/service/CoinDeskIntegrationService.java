package org.javaacademy.bitcoinservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.javaacademy.bitcoinservice.config.CoinDeskProperties;
import org.javaacademy.bitcoinservice.dto.CoindeskDtoRs;
import org.javaacademy.bitcoinservice.exception.IntegrationException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CoinDeskIntegrationService {
    private final RestTemplate restTemplate;
    private final CoinDeskProperties properties;

    /**
     * @return
     * два варианта получения стоимости биткоина в USD
     * через ObjectMapper
     * и через Dto
     * ObjectMapper можно добавить в конфин в виде бина !!
     */
    @SneakyThrows
    public CoindeskDtoRs getCoindeskDtoRs()  {
        ResponseEntity<String> response = restTemplate.getForEntity(properties.getBaseUrl(), String.class);
        ObjectMapper mapper = new ObjectMapper();
        BigDecimal price = mapper.readTree(response.
                getBody()).
                path("bpi").
                path("USD").
                path("rate_float").
                decimalValue();

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
