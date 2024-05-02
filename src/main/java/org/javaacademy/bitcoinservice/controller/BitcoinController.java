package org.javaacademy.bitcoinservice.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.bitcoinservice.dto.BitcoinDtoRq;
import org.javaacademy.bitcoinservice.dto.BitcoinDtoRs;
import org.javaacademy.bitcoinservice.service.FreeCurrencyIntegrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
public class BitcoinController {
    private final FreeCurrencyIntegrationService calcService;

    @PostMapping("/now")
    public BitcoinDtoRs transferMoney(@RequestBody BitcoinDtoRq bitcoinDtoRq) {
        return calcService.c;
    }


}
