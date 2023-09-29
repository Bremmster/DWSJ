package com.karlson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.pokemondata.model.Pokemon;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/pokemons/publish");

    public void postToWebAPI(Pokemon pokemon) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            String json = objectMapper.writeValueAsString(pokemon);
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                LOGGER.info(String.format("Response code -> %s, body -> %s ", response.getCode(), EntityUtils.toString(response.getEntity())));
            } catch (ParseException e) {
                throw new ParseException(e.toString());
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
