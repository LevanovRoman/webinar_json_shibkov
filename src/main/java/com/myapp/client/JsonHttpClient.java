package com.myapp.client;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonHttpClient {

    private final String currencyUrl;

    public JsonHttpClient(String currencyUrl) {
        this.currencyUrl = currencyUrl;
    }
    //    private final String CURRENCY_URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    public String getCurrencies(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(currencyUrl))
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
