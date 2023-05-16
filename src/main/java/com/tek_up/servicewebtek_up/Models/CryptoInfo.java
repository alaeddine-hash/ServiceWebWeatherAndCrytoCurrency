package com.tek_up.servicewebtek_up.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CryptoInfo {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("CurrentPrice")
    private double currentPrice;

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("Rank")
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @JsonProperty("Id")
    private String id;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
