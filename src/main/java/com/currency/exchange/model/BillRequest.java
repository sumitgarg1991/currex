package com.currency.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {
	private List<BillItem> items;
	private UserType userType;
	private int yearsCustomer;
	private String originalCurrency;
	private String targetCurrency;
}
