package com.tek_up.servicewebtek_up.Models;

public class ExchangeInfo {
    private String location;
    private WeatherInfo weather;
    private CurrencyInfo currency;
    private CryptoInfo crypto; // New field

    // Constructors
    public ExchangeInfo() {
    }

    public ExchangeInfo(String location, WeatherInfo weather, CurrencyInfo currency, CryptoInfo crypto) {
        this.location = location;
        this.weather = weather;
        this.currency = currency;
        this.crypto = crypto; // Initialize the new field
    }

    // Getters and Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public WeatherInfo getWeather() {
        return weather;
    }

    public void setWeather(WeatherInfo weather) {
        this.weather = weather;
    }

    public CurrencyInfo getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyInfo currency) {
        this.currency = currency;
    }

    public CryptoInfo getCrypto() { // New getter
        return crypto;
    }

    public void setCrypto(CryptoInfo crypto) { // New setter
        this.crypto = crypto;
    }
}
