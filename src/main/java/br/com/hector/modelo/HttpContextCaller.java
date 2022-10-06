package br.com.hector.modelo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpContextCaller {

    private ApiRequest apiRequest;
    private int responseStatus;

    public HttpContextCaller(ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    public String getResponseBody() throws URISyntaxException, IOException, InterruptedException {
        String responseString;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI(this.apiRequest.getUrl()))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        responseString = response.body();
        this.responseStatus = response.statusCode();
        return responseString;
    }

    public int getResponseStatus() {
        return this.responseStatus;
    }

}
