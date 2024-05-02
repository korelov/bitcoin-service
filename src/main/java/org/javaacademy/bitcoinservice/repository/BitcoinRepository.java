package org.javaacademy.bitcoinservice.repository;

import org.javaacademy.bitcoinservice.dto.BitcoinDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Objects;

@Component
public class BitcoinRepository {
    LinkedList<BitcoinDto> requestHistory = new LinkedList<>();

    public void add(BitcoinDto bitcoinDto) {
        requestHistory.add(bitcoinDto);
    }

    public LinkedList<BitcoinDto> getAll() {
        return requestHistory;
    }

    public BigDecimal averageRubCoast() {
        BigDecimal sumCoast = requestHistory.stream()
                .map(BitcoinDto::getRublesCost)
                .filter(Objects::nonNull)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new RuntimeException("No rates now!"));
        return sumCoast.divide(BigDecimal.valueOf(requestHistory.size()));
    }
}
