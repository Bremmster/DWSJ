package com.karlson.application;

import com.karlson.application.helpers.TextManager;
import com.karlson.application.helpers.UserInputManager;
import com.karlson.kafka.KafkaConsumer;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.service.HttpClient;

import java.util.Random;

public class Menu {

    private final Random random;
    private final HttpClient httpClient;
    private final KafkaConsumer kafkaConsumer;

    public Menu(Random random, HttpClient httpClient, KafkaConsumer kafkaConsumer) {
        this.random = random;
        this.httpClient = httpClient;
        this.kafkaConsumer = kafkaConsumer;
        mainMenu();
    }

    private void mainMenu() {

        boolean viewAllPokemons = false; // true resets the message counter, gets all messages

        while (true) {

            TextManager.viewPokemons(kafkaConsumer.fetchKafkaData(viewAllPokemons));

            TextManager.mainMenu();

            switch (UserInputManager.getLimitedInt(1, 3)) {
                case 1 -> {
                    viewAllPokemons = false;
                    findPokemonMenu();
                }
                case 2 -> viewAllPokemons = false; // check kafka topic for updates
                case 3 -> viewAllPokemons = true; // Reset Kafka consumer, get all messages
                case 9 -> {
                    System.exit(0);
                    return;
                }
                default -> TextManager.notValidChoice();
            }
        }
    }

    private void findPokemonMenu() {
        Pokemon pokemon = new Pokemon("<No name>", random);
        TextManager.findPokemon(pokemon);

        while (true) {
            switch (UserInputManager.getLimitedInt(1, 1)) {
                case 1 -> {
                    pokemon.setName(UserInputManager.getString());
                    TextManager.timeOut();
                    httpClient.post(pokemon);
                    return;
                }
                case 9 -> {
                    return;
                }
                default -> TextManager.notValidChoice();
            }
        }
    }
}
