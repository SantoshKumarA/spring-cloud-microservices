package com.santoshkumar.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-conversion/from/{codeFrom}/to/{codeTo}/quantity/{quantity}")
    public CurrencyConversion retrieveCurrencyConversion(
            @PathVariable String codeFrom,
            @PathVariable String codeTo,
            @PathVariable BigDecimal quantity
    ) {
        return new CurrencyConversion(1001L, codeFrom, codeTo, new BigDecimal(65),
                environment.getProperty("spring.application.name"), quantity, quantity.multiply(new BigDecimal(65)));
    }
    private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
    @GetMapping("/currency-conversion-rest-template/from/{codeFrom}/to/{codeTo}/quantity/{quantity}")
    public CurrencyConversion retrieveCurrencyConversionUsingRestTemplate(
            @PathVariable String codeFrom,
            @PathVariable String codeTo,
            @PathVariable BigDecimal quantity
    ) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("codeFrom", codeFrom);
        uriVariables.put("codeTo", codeTo);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/currency-exchange/from/{codeFrom}/to/{codeTo}", CurrencyConversion.class, uriVariables);
        logger.info(responseEntity.toString());
        if (responseEntity.getStatusCode() == HttpStatusCode.valueOf(200)) {
            logger.info("Http Status code is 200");
            /*CurrencyConversion currencyConversion = responseEntity.getBody();
            if (currencyConversion != null) {
                currencyConversion.setTotalConvertedAmount(quantity.multiply(currencyConversion.getConversionRate()));
                currencyConversion.setQuantity(quantity);
            }
            return currencyConversion;*/
        }
        /*else {
            return new CurrencyConversion(0L, codeFrom, codeTo, new BigDecimal(0), "", quantity, new BigDecimal(0));
        }*/
        CurrencyConversion currencyConversion = responseEntity.getBody();
        if (currencyConversion != null) {
            currencyConversion.setTotalConvertedAmount(quantity.multiply(currencyConversion.getConversionRate()));
            currencyConversion.setQuantity(quantity);
            currencyConversion.setServiceName(currencyConversion.getServiceName() + " - via Rest Template.");
        }
        return currencyConversion;
    }

    @Autowired
    private CurrencyExchangeServiceClient exchangeServiceClient;
    @GetMapping("/currency-conversion-feign/from/{codeFrom}/to/{codeTo}/quantity/{quantity}")
    public CurrencyConversion retrieveCurrencyConversionUsingFeign(
            @PathVariable String codeFrom,
            @PathVariable String codeTo,
            @PathVariable BigDecimal quantity
    ) {

        CurrencyConversion currencyConversion = exchangeServiceClient.retrieveCurrencyExchange(codeFrom, codeTo);
        logger.info(currencyConversion.toString());
        currencyConversion.setTotalConvertedAmount(quantity.multiply(currencyConversion.getConversionRate()));
        currencyConversion.setQuantity(quantity);
        currencyConversion.setServiceName(currencyConversion.getServiceName() + " - via Feign.");
        return currencyConversion;

        /*return new CurrencyConversion(1001L, codeFrom, codeTo, new BigDecimal(65),
                environment.getProperty("spring.application.name"), quantity, quantity.multiply(new BigDecimal(65)));*/
    }
}
