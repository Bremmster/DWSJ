package com.karlson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.pokemondata.model.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class RestClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    private final ObjectMapper objectMapper;
    private static final String API_URL = "http://localhost:8080/api/v1/pokemons/publish";

    public RestClient() {
        this.objectMapper = new ObjectMapper();
    }

    public void sendMessage(Pokemon pokemon) {
        try {
            String postData = objectMapper.writeValueAsString(pokemon);

            URL url = new URL(API_URL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // send POST data
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.write(postData.getBytes());
            }

            // Get response
            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                LOGGER.error(String.format("Response code:  %s", responseCode));
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                LOGGER.info(String.format("Response body %s ", response));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
