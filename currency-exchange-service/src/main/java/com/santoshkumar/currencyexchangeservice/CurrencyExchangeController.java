package com.santoshkumar.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController()
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repo;

	private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
    @GetMapping("/currency-exchange/from/{codeFrom}/to/{codeTo}")
    public Object retrieveExchange(@PathVariable String codeFrom, @PathVariable String codeTo) {
		// return new CurrencyExchange(100L, "USD", "INR", new BigDecimal(83), environment.getProperty("spring.application.name"));
		String service_name = environment.getProperty("spring.application.name") + " - " + environment.getProperty("server.port");
    	CurrencyExchange currencyExchange = repo.findByCodeFromAndCodeTo(codeFrom, codeTo);

		logger.info(service_name);

    	if (currencyExchange != null) {
			logger.info(currencyExchange.toString());
    		currencyExchange.setServiceName(service_name);
    		return currencyExchange;
    	}
    	else {
			// enhance to return a Http Status Code of 404 instead of 200
    		return new CurrencyExchange(0L, codeFrom, codeTo, new BigDecimal(0), service_name);
    	}
    }
}
