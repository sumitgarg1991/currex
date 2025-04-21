package com.currency.exchange;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.currency.exchange.controller.BillController;
import com.currency.exchange.model.BillItem;
import com.currency.exchange.model.BillRequest;
import com.currency.exchange.model.UserType;
import com.currency.exchange.service.BillService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BillController.class)
class BillControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BillService billService;

	@Test
	void testCalculateEndpoint() throws Exception {
		BillRequest request = new BillRequest(List.of(new BillItem("TV", "electronics", 400)), UserType.EMPLOYEE, 1,
				"USD", "EUR");

		when(billService.calculateFinalAmount(Mockito.any())).thenReturn(280.0);

		mockMvc.perform(post("/api/calculate").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(jsonPath("$.finalAmount").value(280.0)).andExpect(jsonPath("$.currency").value("EUR"));
	}
}
