package com.karlson.application;

import com.karlson.kafka.KafkaConsumer;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.service.HttpClient;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestApiAndKafka {

    private static Pokemon testPokemon;
    private static HttpClient mockHttpClient;
    private static KafkaConsumer mockKafkaConsumer;
    private final HttpClient httpClient = new HttpClient();
    private final KafkaConsumer kafkaConsumer = new KafkaConsumer();

    @BeforeAll
    static void beforeAll() {
        testPokemon = new Pokemon("testPokemon", new Random());

        mockHttpClient = mock(HttpClient.class);
        when(mockHttpClient.post(testPokemon)).thenReturn(200);

        mockKafkaConsumer = mock(KafkaConsumer.class);
        List<Pokemon> sutPokemonList = new ArrayList<>();
        sutPokemonList.add(testPokemon);
        when(mockKafkaConsumer.fetchKafkaData(false)).thenReturn(sutPokemonList);
    }

    @Test
    @Order(1)
    void mockWebApiTest() {

        int expected = 200; // http response code

        int ActualResponse = mockHttpClient.post(testPokemon);

        assertEquals(expected, ActualResponse);
    }


    @Test
    @Order(2)
    void mockKafkaConsumerTest() {
        // Arrange
        String name = testPokemon.getName();
        int total = testPokemon.getTotal();
        // Act
        List<Pokemon> pokemonList = mockKafkaConsumer.fetchKafkaData(false);
        Pokemon kafkaPokemon = pokemonList.get(pokemonList.size() - 1);
        // Assert
        assertEquals(name, kafkaPokemon.getName());
        assertEquals(total, kafkaPokemon.getTotal());
    }

    @Test
    @Order(3)
    @Disabled("Disabled test webApiTest(), Test creates post in production. requires the webserver")
    void webApiTest() {

        int expected = 200; // http response code
        int ActualResponse;

        ActualResponse = httpClient.post(testPokemon);

        assertEquals(expected, ActualResponse);
    }


    @Test
    @Order(4)
    @Disabled("Disabled test kafkaConsumerTest() Reads from kafka topic needs broker. Requires webApiTest() to succeed")
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
