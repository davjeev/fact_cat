package catapi;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Cat_api{
    String fact;
    long factLength;
    public Cat_api() throws Exception{
        
        JSONObject catFact = getCatFact();
        this.fact = (String)catFact.get("fact");
        this.factLength = (long)catFact.get("length");
    }

   private static JSONObject getCatFact() throws Exception{
        String url = "https://catfact.ninja/fact";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        
        HttpResponse <String> response = client.send(request, BodyHandlers.ofString());

        Object fact = new JSONParser().parse(response.body());

        JSONObject factJson = (JSONObject) fact;

        return factJson;
    
    }

    public String getFact(){
        return this.fact;
    }

    public long getFactLength(){
        return this.factLength;
    }
}
