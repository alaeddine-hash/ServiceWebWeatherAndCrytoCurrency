package com.tek_up.servicewebtek_up.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    @JsonProperty("weather")
    private WeatherData[] weatherData;
    @JsonProperty("main")
    private MainData mainData;

    public String getDescription() {
        if (weatherData != null && weatherData.length > 0) {
            return weatherData[0].getDescription();
        }
        return null;
    }

    public float getTemperature() {
        if (mainData != null) {
            return mainData.getTemp();
        }
        return 0.0f;
    }
}
