package com.tek_up.servicewebtek_up.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyData {
    @JsonProperty("Outcome")
    private String outcome;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("ExchangeRate")
    private Double exchangeRate;

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    // Add other fields as necessary

    // Add getters and setters for all fields
}
