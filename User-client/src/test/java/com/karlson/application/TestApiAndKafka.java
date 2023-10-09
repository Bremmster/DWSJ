package com.karlson.application;

import com.karlson.kafka.KafkaConsumer;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.service.HttpClient;
import org.apache.hc.core5.http.HttpException;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestApiAndKafka {

    private static Pokemon testPokemon;
    private static HttpClient mockHttpClient; // = mock(HttpClient.class);
    private final HttpClient httpClient = new HttpClient();
    private final KafkaConsumer kafkaConsumer = new KafkaConsumer();

    @BeforeAll
    static void beforeAll() {
        testPokemon = new Pokemon("testPokemon", new Random());
//        Create a pokemon to send  todo
//    Create somthing that can compare to?
        mockHttpClient = mock(HttpClient.class);
        try {
            when(mockHttpClient.post(testPokemon)).thenReturn(200);
        } catch (HttpException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(1)
    void mockWebApiTest() {

        int expected = 200; // http response code
        int ActualResponse = 0;
        try {
            ActualResponse = mockHttpClient.post(testPokemon);
        } catch (HttpException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, ActualResponse);
    }

    @Test
    @Order(2)
    @Disabled
        // Warning! Test creates post in production. requires server
    void webApiTest() {

        int expected = 200; // http response code
        int ActualResponse = 0;
        try {
            ActualResponse = httpClient.post(testPokemon);
        } catch (HttpException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, ActualResponse);
    }

    @Test
    @Order(4)
    @Disabled
        // Warning! Reads from kafka topic requires broker.
    void mockKafkaConsumerTest() {
        // Arrange
        String name = testPokemon.getName();
        int total = testPokemon.getTotal();
        // Act todo mock this!
        List<Pokemon> pokemonList = kafkaConsumer.fetchKafkaData(false);
        Pokemon kafkaPokemon = pokemonList.get(pokemonList.size() - 1);
        // Assert
        assertEquals(name, kafkaPokemon.getName());
        assertEquals(total, kafkaPokemon.getTotal());
    }

    @Test
    @Order(4)
    @Disabled
        // Warning! Reads from kafka topic requires broker.
    void kafkaConsumerTest() {
        // Arrange
        String name = testPokemon.getName();
        int total = testPokemon.getTotal();
        // Act
        List<Pokemon> pokemonList = kafkaConsumer.fetchKafkaData(false);
        Pokemon kafkaPokemon = pokemonList.get(pokemonList.size() - 1);
        // Assert
        assertEquals(name, kafkaPokemon.getName());
        assertEquals(total, kafkaPokemon.getTotal());
    }
}
