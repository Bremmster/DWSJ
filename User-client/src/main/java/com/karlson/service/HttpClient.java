package com.karlson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.pokemondata.model.Pokemon;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class HttpClient {

    HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/pokemons/publish");

    ObjectMapper objectMapper = new ObjectMapper();

    public void postToWebAPI(Pokemon pokemon) { // Ta imot som ett json objeckt kanske?
        try {
            String json = objectMapper.writeValueAsString(pokemon);

            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

                StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
                httpPost.setEntity(entity);

                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    int responseCode = response.getCode();
                    HttpEntity responseEntity = response.getEntity();
                    if (responseEntity != null) {
                        System.out.println("Response code: " + responseCode + " Response body -> " + EntityUtils.toString(responseEntity));
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
