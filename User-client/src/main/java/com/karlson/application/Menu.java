package com.karlson.application;

import com.karlson.application.helpers.TextManager;
import com.karlson.application.helpers.UserInputManager;
import com.karlson.kafka.KafkaConsumer;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.service.HttpClient;
import org.apache.hc.core5.http.HttpException;

import java.util.Random;

public class Menu {

    private Random random;
    private HttpClient httpClient;
    private KafkaConsumer kafkaConsumer;

    public Menu() {
        this.random = new Random();
        this.httpClient = new HttpClient();
        this.kafkaConsumer = new KafkaConsumer();
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

                    try {
                        httpClient.post(pokemon);
                    } catch (HttpException e) {
                        throw new RuntimeException(e);
                    }
                        return;
                }
                case 9 -> {
                    return;
                }
            }
        }
    }
}
