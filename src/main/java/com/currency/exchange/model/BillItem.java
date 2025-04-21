package com.currency.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillItem {
    private String name;
    private String category; // e.g., "groceries", "electronics"
    private double amount;
}
