package com.santoshkumar.currencyexchangeservice;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {
		
	@Id
	private Long codeId;
    private String codeFrom;
    private String codeTo;
    private BigDecimal conversionRate;
    private String serviceName;
    
	public CurrencyExchange() {
		super();	
	}

	public CurrencyExchange(Long codeId, String codeFrom, String codeTo, BigDecimal conversionRate,
			String serviceName) {
		super();
		this.codeId = codeId;
		this.codeFrom = codeFrom;
		this.codeTo = codeTo;
		this.conversionRate = conversionRate;
		this.serviceName = serviceName;
	}

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}

	public String getCodeFrom() {
		return codeFrom;
	}

	public void setCodeFrom(String codeFrom) {
		this.codeFrom = codeFrom;
	}

	public String getCodeTo() {
		return codeTo;
	}

	public void setCodeTo(String codeTo) {
		this.codeTo = codeTo;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "CurrencyExchange{" +
				"codeId=" + codeId +
				", codeFrom='" + codeFrom + '\'' +
				", codeTo='" + codeTo + '\'' +
				", conversionRate=" + conversionRate +
				", serviceName='" + serviceName + '\'' +
				'}';
	}
}
