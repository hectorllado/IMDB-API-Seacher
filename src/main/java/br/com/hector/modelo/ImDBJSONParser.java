package br.com.hector.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;

public class ImDBJSONParser implements IJsonParser {

    private String responseString;
    private List<Movies> movies;

    public ImDBJSONParser(String responseString, List<Movies> movies) {
        this.responseString = responseString;
        this.movies = movies;
    }

    public List<Movies> parser() {

        //captura o Json inteiro e transforma em objeto
        JsonElement jsonElement = JsonParser.parseString(responseString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        //Extraindo campos do nosso Json
        JsonArray items = jsonObject.get("items").getAsJsonArray();

        //Cada itemElement => 1 filme/movie
        for(JsonElement itemElement : items) {
            //essa linha captura cada filme do IMDB
            JsonObject filme = itemElement.getAsJsonObject();

            //Agora podemos extrair dados
            String fullTitle = filme.get("fullTitle").getAsString();
            String image = filme.get("image").getAsString();
            String imDbRating = filme.get("imDbRating").getAsString();
            String year = filme.get("year").getAsString();

            //instanciando Objetos de Filmes
            Movies movie = new Movies(fullTitle, image, imDbRating, year);

            //colocando em uma lista -> Generics
            this.movies.add(movie);
        }

        return this.movies;
    };

}
