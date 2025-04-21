package com.currency.exchange.logic;

import com.currency.exchange.model.BillItem;
import com.currency.exchange.model.BillRequest;
import com.currency.exchange.model.UserType;

public class DiscountCalculator {
    public static double calculateDiscount(BillRequest request) {
        double total = 0;
        double discountableAmount = 0;

        for (BillItem item : request.getItems()) {
            total += item.getAmount();
            if (!item.getCategory().equalsIgnoreCase("groceries")) {
                discountableAmount += item.getAmount();
            }
        }

        double percentageDiscount = 0;
        if (request.getUserType() == UserType.EMPLOYEE) percentageDiscount = 0.3;
        else if (request.getUserType() == UserType.AFFILIATE) percentageDiscount = 0.1;
        else if (request.getYearsCustomer() > 2) percentageDiscount = 0.05;

        double percentDiscountAmount = discountableAmount * percentageDiscount;
        double flatDiscount = ((int) (total / 100)) * 5;
        return percentDiscountAmount + flatDiscount;
    }
}