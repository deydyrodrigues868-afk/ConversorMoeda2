package Business;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Client {

    public static double Resposta(String moedaBase, double valorBase, String moedaConvertida)
            throws IOException, InterruptedException {

       moedaBase=moedaBase.toUpperCase();
       moedaConvertida = moedaConvertida.toUpperCase();

       String API_KEY = "d4e4877ffb187f17e805685c";

       String url = "https://v6.exchangerate-api.com/v6/"
               + API_KEY + "/latest/" + moedaBase;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(response.body(),JsonObject.class);

        double taxa = json.getAsJsonObject("conversion_rates").get(moedaConvertida).getAsDouble();
        return valorBase * taxa;
    }
}
