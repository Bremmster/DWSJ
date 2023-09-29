package com.karlson.application;

import com.karlson.application.helpers.TextManager;
import com.karlson.application.helpers.UserInputManager;
import com.karlson.kafka.KafkaConsumer;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.service.HttpClient;

import java.util.Random;

public class Menu {

    Random random;
    HttpClient httpClient;
    KafkaConsumer kafkaConsumer;

    public Menu() {
        this.random = new Random();
        this.httpClient = new HttpClient();
        this.kafkaConsumer = new KafkaConsumer();
        mainMenu();
    }

    private void mainMenu() {

        boolean viewAllPokemons = false; // true resets the message counter, gets all messages
        while (true) {
            // Views messages from kafka broker
            TextManager.viewPokemons(kafkaConsumer.getKafkaData(viewAllPokemons));

            TextManager.mainMenu();
            switch (UserInputManager.getLimitedInt(1, 3)) {
                case 1 -> {
                    viewAllPokemons = false;
                    findPokemonMenu();
                }
                case 2 -> viewAllPokemons = false;
                case 3 -> viewAllPokemons = true;
                case 9 -> {
                    System.exit(0);
                    return; // Sonarlint gets angry if its removed
                }
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
                    httpClient.postToWebAPI(pokemon);
                    return;
                }
                case 9 -> {
                    return;
                }
            }
        }
    }
}
