package com.tek_up.servicewebtek_up.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tek_up.servicewebtek_up.Models.CurrencyData;

public class CurrencyResponse {
    @JsonProperty("Currencies")
    private CurrencyData currencies;

    @JsonProperty("Outcome")
    private String outcome;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Identity")
    private String identity;

    @JsonProperty("Delay")
    private double delay;

    // Add getters and setters for all fields

    public CurrencyData getCurrencies() {
        return currencies;
    }

    public void setCurrencies(CurrencyData currencies) {
        this.currencies = currencies;
    }

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }
}
