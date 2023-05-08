package com.microservice.APIGateway.Configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-converter/**")
							 .filters(f -> f.addRequestHeader("MyHeader", "MyValue")).uri("lb://currency-converter"))
				.route(p -> p.path("/currency-converter-new/**")
							 .filters(f -> f.rewritePath("/currency-converter-new/(?<segment>.*)", "/currency-converter/${segment}"))
							 .uri("lb://currency-converter"))
				.build();
	}
	
}
