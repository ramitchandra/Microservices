package com.microservice.CurrencyConverter.Helper;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ramit
 *	This is mandatory for zipkin to log properly rest template calls
 *	Rest template has to called using autowired else it wont be logged properly
 */
@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
