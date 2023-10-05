package com.karlson.application;

import com.karlson.kafka.KafkaConsumer;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.service.HttpClient;
import org.apache.hc.core5.http.HttpException;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestApiAndKafka {

    private static Pokemon testPokemon;
    private final HttpClient httpClient = new HttpClient();
    private final KafkaConsumer kafkaConsumer = new KafkaConsumer();

    @BeforeAll
    static void beforeAll() {
        testPokemon = new Pokemon("testPokemon", new Random());
//        Create a pokemon to send  todo
//    Create somthing that can compare to?

    }

    @Test
    @Order(1)
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
    @Order(2)
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
