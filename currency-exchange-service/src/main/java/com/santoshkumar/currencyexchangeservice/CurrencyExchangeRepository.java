package com.santoshkumar.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	public CurrencyExchange findByCodeFromAndCodeTo(String codeFrom, String codeTo);
}
