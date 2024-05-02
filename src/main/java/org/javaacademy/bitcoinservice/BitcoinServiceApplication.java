package org.javaacademy.bitcoinservice;

import org.javaacademy.bitcoinservice.config.FreeCurrencyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BitcoinServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BitcoinServiceApplication.class, args);
		FreeCurrencyProperties bean = context.getBean(FreeCurrencyProperties.class);
		System.out.println(bean.getBaseUrl());
		System.out.println(bean.getToken());
		System.out.println(bean.getHeadertokenname());
	}

}
