package br.com.hector.modelo;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ApiRequest {

    private final String apiKey = "k_xe42rlo2";
    private String url;

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

