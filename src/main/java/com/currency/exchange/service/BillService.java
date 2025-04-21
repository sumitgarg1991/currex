package com.currency.exchange.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.currency.exchange.logic.DiscountCalculator;
import com.currency.exchange.model.BillItem;
import com.currency.exchange.model.BillRequest;

@Service
public class BillService {

    @Autowired
    private ExchangeRateService exchangeRateService;

    public double calculateFinalAmount(BillRequest billRequest) {
        double totalAmount = billRequest.getItems().stream().mapToDouble(BillItem::getAmount).sum();
        double discount = DiscountCalculator.calculateDiscount(billRequest);
        double discountedAmount = totalAmount - discount;
        double rate = exchangeRateService.getExchangeRate(billRequest.getOriginalCurrency(), billRequest.getTargetCurrency());
        return discountedAmount * rate;
    }
}
