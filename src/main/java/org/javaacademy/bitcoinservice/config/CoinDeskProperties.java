package org.javaacademy.bitcoinservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "integration.coindesk")
@Getter
@Configuration
@Setter
public class CoinDeskProperties {
    private String baseUrl;
}
