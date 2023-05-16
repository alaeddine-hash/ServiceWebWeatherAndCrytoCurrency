package com.tek_up.servicewebtek_up.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tek_up.servicewebtek_up.Models.CryptoData;
import com.tek_up.servicewebtek_up.Models.CryptoInfo;
import com.tek_up.servicewebtek_up.Models.CryptoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class CryptoService {
    @Value("${currency.user.token}")
    private String userToken;

    public CryptoInfo getCryptoInfo(String cryptoCurrency) {
        try {
            String url = "https://crypto.xignite.com/xCrypto.json/ListCryptos?Exchange=All&_token=" + userToken;
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
            CryptoResponse cryptoResponse = objectMapper.readValue(response.toString(), CryptoResponse.class);

            // Debug: Print the cryptoResponse object
            System.out.println("CryptoResponse: " + cryptoResponse);

            // You need to change the logic below according to CryptoResponse structure
            if (cryptoResponse.getCryptos() != null) {
                List<CryptoData> cryptoDataList = cryptoResponse.getCryptos();
                for (CryptoData cryptoData : cryptoDataList) {
                    System.out.println("Crypto currency: " + cryptoData.getName());
                    if (cryptoData.getName() != null && cryptoData.getName().equalsIgnoreCase(cryptoCurrency)) {
                        CryptoInfo cryptoInfo = new CryptoInfo();
                        cryptoInfo.setName(cryptoData.getName());
                        cryptoInfo.setSymbol(cryptoData.getSymbol());
                        // Add more fields as per your requirement
                        return cryptoInfo;
                    }
                }
                throw new RuntimeException("Crypto currency not found: " + cryptoCurrency);
            } else {
                throw new RuntimeException("Cryptos is null in the response.");
            }
        } catch (Exception e) {
            // Handle any exceptions that occur
            e.printStackTrace();
        }

        return null;
    }
}
