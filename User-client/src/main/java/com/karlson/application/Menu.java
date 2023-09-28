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
        while (true) {
            // Get unconsumed messages from the kafka broker
            kafkaConsumer.getKafkaData(false);


            TextManager.mainMenu();
            switch (UserInputManager.getLimitedInt(1, 2)) {
                case 1 -> findPokemonMenu();
                case 2 -> kafkaConsumer.getKafkaData(false); // resets the message counter gets all messages
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
