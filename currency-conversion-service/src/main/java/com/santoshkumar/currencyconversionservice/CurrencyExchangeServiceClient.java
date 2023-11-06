package com.santoshkumar.currencyconversionservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name = "currency-exchange-service", url = "http://localhost:8080")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceClient {
    @GetMapping("/currency-exchange/from/{codeFrom}/to/{codeTo}")
    CurrencyConversion retrieveCurrencyExchange(@PathVariable String codeFrom, @PathVariable String codeTo);
}
