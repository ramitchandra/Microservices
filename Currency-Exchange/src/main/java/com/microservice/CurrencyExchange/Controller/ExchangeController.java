package com.microservice.CurrencyExchange.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class ExchangeController {
	
	@GetMapping("/getStatus")
	public String getStatus() {
		return "Currency Exchange Service is up!!!";
	}
	
	@GetMapping("/getValue")
	public String getExchangeValue() {
		return "This value is from Currency Exchange";
	}

}
