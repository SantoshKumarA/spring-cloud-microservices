package com.santoshkumar.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {

    private Long codeId;
    private String codeFrom;
    private String codeTo;
    private BigDecimal conversionRate;
    private String serviceName;
    private BigDecimal quantity;
    private BigDecimal totalConvertedAmount;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Long codeId, String codeFrom, String codeTo, BigDecimal conversionRate, String serviceName, BigDecimal quantity, BigDecimal totalConvertedAmount) {
        this.codeId = codeId;
        this.codeFrom = codeFrom;
        this.codeTo = codeTo;
        this.conversionRate = conversionRate;
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.totalConvertedAmount = totalConvertedAmount;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalConvertedAmount() {
        return totalConvertedAmount;
    }

    public void setTotalConvertedAmount(BigDecimal totalConvertedAmount) {
        this.totalConvertedAmount = totalConvertedAmount;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "codeId=" + codeId +
                ", codeFrom='" + codeFrom + '\'' +
                ", codeTo='" + codeTo + '\'' +
                ", conversionRate=" + conversionRate +
                ", serviceName='" + serviceName + '\'' +
                ", quantity=" + quantity +
                ", totalConvertedAmount=" + totalConvertedAmount +
                '}';
    }
}
