package com.tek_up.servicewebtek_up.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoData {


    @JsonProperty("Name")
    private String name;

    @JsonProperty("Symbol")
    private String symbol;


    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }



    // Additional method to handle null values
    public String getNonNullName() {
        return name != null ? name : "";
    }
}
