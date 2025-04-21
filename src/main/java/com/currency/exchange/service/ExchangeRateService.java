package com.currency.exchange.service;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.common.cache.*;

@Service
public class ExchangeRateService {

    private final String apiKey = "43ff5c501785a9b47ace812a";

    // Cache to store exchange rates: key = "USD-EUR", value = exchange rate
    private final Cache<String, Double> rateCache = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.HOURS)
            .maximumSize(1000)
            .build();

    public double getExchangeRate(String from, String to) {
        try {
            String cacheKey = from + "-" + to;
            Double cachedRate = rateCache.getIfPresent(cacheKey);

            if (cachedRate != null) {
                return cachedRate;
            }

            // API Call
            String url = String.format("https://open.er-api.com/v6/latest/%s?apikey=%s", from, apiKey);
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            Map<String, Object> rates = (Map<String, Object>) response.get("rates");

            double rate = ((Number) rates.get(to)).doubleValue();
            rateCache.put(cacheKey, rate);
            return rate;

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch exchange rate", e);
        }
    }
}
