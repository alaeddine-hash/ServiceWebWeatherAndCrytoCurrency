package com.tek_up.servicewebtek_up.Controllers;

import com.tek_up.servicewebtek_up.Models.CryptoInfo;
import com.tek_up.servicewebtek_up.Models.CurrencyInfo;
import com.tek_up.servicewebtek_up.Models.ExchangeInfo;
import com.tek_up.servicewebtek_up.Models.WeatherInfo;
import com.tek_up.servicewebtek_up.Service.CryptoService;
import com.tek_up.servicewebtek_up.Service.CurrencyService;
import com.tek_up.servicewebtek_up.Service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExchangeInfoController {
    private final WeatherService weatherService;
    private final CurrencyService currencyService;
    private final CryptoService cryptoService;

    public ExchangeInfoController(WeatherService weatherService, CurrencyService currencyService, CryptoService cryptoService) {
        this.weatherService = weatherService;
        this.currencyService = currencyService;
        this.cryptoService = cryptoService;
    }

    @Operation(summary = "Get exchange information for a location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Location not found")
    })
    @GetMapping("/exchange-info/{location}")
    public ExchangeInfo getExchangeInfo(@PathVariable @Parameter(description = "Location") String location) {
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(location);
        CurrencyInfo currencyInfo = currencyService.getCurrencyInfo("USD", "EUR");

        ExchangeInfo exchangeInfo = new ExchangeInfo();
        exchangeInfo.setLocation(location);
        exchangeInfo.setWeather(weatherInfo);
        exchangeInfo.setCurrency(currencyInfo);

        return exchangeInfo;
    }

    @Operation(summary = "Get crypto exchange information for a location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Location not found")
    })
    @GetMapping("/crypto-exchange-info/{location}")
    public ExchangeInfo getCryptoExchangeInfo(@PathVariable @Parameter(description = "Location") String location) {
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(location);
        CryptoInfo cryptoInfo = cryptoService.getCryptoInfo("Bitcoin");

        ExchangeInfo exchangeInfo = new ExchangeInfo();
        exchangeInfo.setLocation(location);
        exchangeInfo.setWeather(weatherInfo);
        exchangeInfo.setCrypto(cryptoInfo);

        return exchangeInfo;
    }
}
