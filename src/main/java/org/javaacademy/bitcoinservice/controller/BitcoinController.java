package org.javaacademy.bitcoinservice.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.bitcoinservice.dto.BitcoinDtoRs;
import org.javaacademy.bitcoinservice.service.BitcoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.LinkedList;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
public class BitcoinController {
    private final BitcoinService bitcoinService;

    @GetMapping("/now")
    public BitcoinDtoRs getBitcoinRubCost() {
        return bitcoinService.getBitcoinRubCost();
    }

    @GetMapping("/history")
    public LinkedList<BitcoinDtoRs> getAll() {
        return bitcoinService.getAll();
    }

    @GetMapping("/average")
    public BigDecimal averageRubCoast() {
        return bitcoinService.averageRubCoast();
    }
}
