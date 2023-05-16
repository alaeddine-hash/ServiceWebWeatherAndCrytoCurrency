package com.tek_up.servicewebtek_up.Controllers;

import com.tek_up.servicewebtek_up.Models.CryptoInfo;
import com.tek_up.servicewebtek_up.Models.CurrencyInfo;
import com.tek_up.servicewebtek_up.Models.ExchangeInfo;
import com.tek_up.servicewebtek_up.Models.WeatherInfo;
import com.tek_up.servicewebtek_up.Service.CryptoService;
import com.tek_up.servicewebtek_up.Service.CurrencyService;
import com.tek_up.servicewebtek_up.Service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeInfoController {
    private final WeatherService weatherService;
    private final CurrencyService currencyService;
    private final CryptoService cryptoService;

    public ExchangeInfoController(WeatherService weatherService, CurrencyService currencyService, CryptoService cryptoService) {
        this.weatherService = weatherService;
        this.currencyService = currencyService;
        this.cryptoService = cryptoService;
    }

    @GetMapping("/exchange-info/{location}")
    public ExchangeInfo getExchangeInfo(@PathVariable String location) {
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(location);
        CurrencyInfo currencyInfo = currencyService.getCurrencyInfo("USD", "EUR"); // example

        ExchangeInfo exchangeInfo = new ExchangeInfo();
        exchangeInfo.setLocation(location);
        exchangeInfo.setWeather(weatherInfo);
        exchangeInfo.setCurrency(currencyInfo);

        return exchangeInfo;
    }

    @GetMapping("/crypto-exchange-info/{location}")
    public ExchangeInfo getCryptoExchangeInfo(@PathVariable String location) {
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(location);
        System.out.println(weatherInfo.getDescription()+weatherInfo.getTemperature());
        CryptoInfo cryptoInfo = cryptoService.getCryptoInfo("Bitcoin"); // example

        ExchangeInfo exchangeInfo = new ExchangeInfo();
        exchangeInfo.setLocation(location);
        exchangeInfo.setWeather(weatherInfo);
        exchangeInfo.setCrypto(cryptoInfo);

        return exchangeInfo;
    }
}
