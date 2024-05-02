package org.javaacademy.bitcoinservice.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.bitcoinservice.dto.BitcoinDtoRs;
import org.javaacademy.bitcoinservice.dto.FreeCurrencyDtoRs;
import org.javaacademy.bitcoinservice.repository.BitcoinRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BitcoinService {
    private static final String RUB = "RUB";
    private final FreeCurrencyIntegrationService freeCurrencyIntegrationService;
    private final CoinDeskIntegrationService coinDeskIntegrationService;
    private final BitcoinRepository bitcoinRepository;


    public BitcoinDtoRs getBitcoinRubCost() {
        BigDecimal dollarOfRubles =
                freeCurrencyIntegrationService.getFreeCurrencyDtoRs().getData().get(RUB);
        BigDecimal bitcoinOfDollar =
                coinDeskIntegrationService.getCoindeskDtoRs().getBpi().usd.rate_float;
        BigDecimal rubCost = bitcoinOfDollar.multiply(dollarOfRubles);
        BitcoinDtoRs bitcoinRub = new BitcoinDtoRs(LocalDateTime.now(), rubCost);
        bitcoinRepository.add(bitcoinRub);
        return bitcoinRub;
    }

    public LinkedList<BitcoinDtoRs> getAll() {
        return bitcoinRepository.getAll();
    }

    public BigDecimal averageRubCoast() {
        return bitcoinRepository.averageRubCoast();
    }
}
