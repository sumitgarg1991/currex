package com.currency.exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.currency.exchange.service.ExchangeRateService;

class ExchangeRateServiceTest {

	private ExchangeRateService service;
	private RestTemplate restTemplate;

	@BeforeEach
	void setup() {
		service = new ExchangeRateService();
	}

	@Test
	void testExchangeRateCaching() {
		double rate1 = service.getExchangeRate("USD", "EUR");
		double rate2 = service.getExchangeRate("USD", "EUR");

		assertEquals(rate1, rate2, "Exchange rate should be cached and equal");
	}
}
