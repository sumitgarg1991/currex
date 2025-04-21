package com.currency.exchange.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.currency.exchange.model.BillRequest;
import com.currency.exchange.service.BillService;

@RestController
@RequestMapping("/api")
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping("/calculate")
	public ResponseEntity<Map<String, Object>> calculatePayableAmount(@RequestBody BillRequest billRequest) {
		double amount = billService.calculateFinalAmount(billRequest);
		Map<String, Object> response = new HashMap<>();
		response.put("finalAmount", amount);
		response.put("currency", billRequest.getTargetCurrency());
		return ResponseEntity.ok(response);
	}
}