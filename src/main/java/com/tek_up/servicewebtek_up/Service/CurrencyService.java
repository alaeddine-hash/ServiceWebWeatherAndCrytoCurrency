package com.tek_up.servicewebtek_up.Service;

import com.tek_up.servicewebtek_up.Models.CurrencyData;
import com.tek_up.servicewebtek_up.Models.CurrencyInfo;
import com.tek_up.servicewebtek_up.Models.CurrencyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class CurrencyService {

    @Value("${currency.user.token}")
    private String userToken;

    public CurrencyInfo getCurrencyInfo(String baseCurrency, String targetCurrency) {
        try {
            String url = "https://www.xignite.com/xCurrencies.json/ListCurrencies?&_token=" + userToken;
            URL baseUrl = new URL(url);
            URLConnection conn = baseUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Debug: Print the response received from the API
            System.out.println("Response: " + response.toString());

            // Parse the response and extract the relevant information
            ObjectMapper objectMapper = new ObjectMapper();
            CurrencyResponse currencyResponse = objectMapper.readValue(response.toString(), CurrencyResponse.class);

            // Debug: Print the currencyResponse object
            System.out.println("CurrencyResponse: " + currencyResponse);

            if (currencyResponse.getCurrencies() != null) {
                CurrencyData currencyData = currencyResponse.getCurrencies(); // Assuming there is only one CurrencyData object
                CurrencyInfo currencyInfo = new CurrencyInfo();
                currencyInfo.setBaseCurrency(baseCurrency);
                currencyInfo.setTargetCurrency(targetCurrency);
                currencyInfo.setExchangeRate(currencyData.getExchangeRate());
                return currencyInfo;
            } else {
                throw new RuntimeException("Currencies is null in the response.");
            }
        } catch (Exception e) {
            // Handle any exceptions that occur
            e.printStackTrace();
        }

        return null;
    }

}
