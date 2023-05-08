package com.microservice.CurrencyConverter.Helper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/getValue")
	public String getExchangeValue();
	

}
