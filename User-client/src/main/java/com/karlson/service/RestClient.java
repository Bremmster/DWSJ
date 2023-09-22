package com.karlson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.pokemondata.model.Pokemon;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class RestClient {
    private final ObjectMapper objectMapper;
    private final String apiUrl = "http://localhost:8080/api/v1/pokemons/publish";

    ;

    private String postData;

    public RestClient() {
        this.objectMapper = new ObjectMapper();
    }

    public void sendMessage(Pokemon pokemon) {
        try {
            this.postData = objectMapper.writeValueAsString(pokemon);

            System.out.println(postData);

            URL url = new URL(apiUrl);

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
            System.out.printf("Response code:  %s", responseCode);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.printf("Response body %s ", response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
