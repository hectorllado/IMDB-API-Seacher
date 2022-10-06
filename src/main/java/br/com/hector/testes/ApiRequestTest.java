package br.com.hector.testes;

import br.com.hector.modelo.*;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ApiRequestTest {
    private static String responseString;
    private static int responseStatusCode;

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        List<Movies> movies = new ArrayList<Movies>();

        //instancia a classe ApiRequest e seta a URL desejada da chamada, assim como a ApiKey (oculta)
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setUrl("https://imdb-api.com/en/API/Top250Movies/" + apiRequest.getApiKey());

        //chama a classe que manipula todas as chamadas HTTP
        HttpContextCaller httpContextCaller = new HttpContextCaller(apiRequest);
        //captura respostas do objeto
        responseString = httpContextCaller.getResponseBody();
        responseStatusCode = httpContextCaller.getResponseStatus();

        //print código de status
        System.out.println(responseStatusCode);

        //chama classe que manipula os JSON
        ImDBJSONParser imDBJSONParser = new ImDBJSONParser(responseString, movies);
        movies = imDBJSONParser.parser();

        //cria um novo arquivo HTML
        File file = new File ("C:\\Users\\hector.llado\\OneDrive - Iteris Consultoria e Software\\Documentos\\IMDB API Seacher");

        //instancia um printwriter para escrita no arquivo
        PrintWriter saidaHTML = new PrintWriter ("saida.html");

        //instancia um HTMLGenerator
        HTMLGenerator htmlGenerator = new HTMLGenerator(saidaHTML);
        //consome o metodo generate
        htmlGenerator.generate(movies);

    }
}
