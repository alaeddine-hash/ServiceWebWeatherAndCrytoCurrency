package com.tek_up.servicewebtek_up.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoResponse {
    @JsonProperty("Cryptos")
    private List<CryptoData> Cryptos;

    @JsonProperty("Delay")
    private double delay;

    @JsonProperty("Outcome")
    private String outcome;

    @JsonProperty("Identity")
    private String identity;

    @JsonProperty("Message")
    private String message;

    // Getters and Setters

    public List<CryptoData> getCryptos() {
        return Cryptos;
    }

    public void setCryptos(List<CryptoData> cryptos) {
        this.Cryptos = cryptos;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
