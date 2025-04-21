package com.currency.exchange.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.currency.exchange.model.LoginRequest;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody LoginRequest request) {
		Map<String, Object> response = new HashMap<>();

		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			response.put("message", "Login successful");
			response.put("user", authentication.getName());
			// You could return a token here if using JWT
		} catch (AuthenticationException e) {
			response.put("message", "Invalid credentials");
		}

		return response;
	}
}
