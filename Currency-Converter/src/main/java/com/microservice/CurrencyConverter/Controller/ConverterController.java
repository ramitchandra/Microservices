package com.microservice.CurrencyConverter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.CurrencyConverter.Helper.CurrencyExchangeProxy;

@RestController
@RequestMapping("/currency-converter")
public class ConverterController {
	
	@Autowired
	private CurrencyExchangeProxy exchangeProxy;

	@GetMapping("/getStatus")
	public String getStatus() {
		return "Currency Converter Service is up!!!";
	}
	
	@GetMapping("/feign/otherService")
	//@Retry(name = "sample", fallbackMethod = "hardcodedResponse") --- for retries in case of failure or slow response
	//@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")  --- for retries in case of failure or slow response
	//@RateLimiter(name="default") --- for limiting number of call in provided time
	//@Bulkhead(name="default") --- for limiting number of parallel calls on api
	public String otherServiceValue() {
		return exchangeProxy.getExchangeValue();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallbackResponse";
	}
}
