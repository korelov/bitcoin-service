package org.javaacademy.bitcoinservice.repository;

import org.javaacademy.bitcoinservice.dto.BitcoinDtoRs;
import org.javaacademy.bitcoinservice.exception.IntegrationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Objects;

@Component
public class BitcoinRepository {
    LinkedList<BitcoinDtoRs> requestHistory = new LinkedList<>();

    public void add(BitcoinDtoRs bitcoinDtoRs) {
        requestHistory.add(bitcoinDtoRs);
    }

    public LinkedList<BitcoinDtoRs> getAll() {
        return requestHistory;
    }

    public BigDecimal averageRubCoast() {
        BigDecimal sumCoast = requestHistory.stream()
                .map(BitcoinDtoRs::getRublesCost)
                .filter(Objects::nonNull)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new RuntimeException("No rates now!"));
        return sumCoast.divide(BigDecimal.valueOf(requestHistory.size()));
    }
}
