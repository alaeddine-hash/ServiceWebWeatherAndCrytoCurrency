package com.tek_up.servicewebtek_up.Service;

import com.tek_up.servicewebtek_up.Models.WeatherInfo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        configureRestTemplate();
    }

    public WeatherInfo getWeatherInfo(String location) {
        String apiKey = "6e2dba07979ec3f4d9cba0fdb5612a6d";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + location + ",us&APPID=" + apiKey;

        return restTemplate.getForObject(url, WeatherInfo.class);
    }

    private void configureRestTemplate() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
    }
}
