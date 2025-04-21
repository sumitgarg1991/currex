package com.currency.exchange.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
