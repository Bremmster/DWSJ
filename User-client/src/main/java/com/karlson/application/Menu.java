package com.karlson.application;

import com.karlson.application.helpers.TextManager;
import com.karlson.application.helpers.UserInputManager;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.service.HttpClient;
import com.karlson.service.RestClient;

import java.util.Random;

public class Menu {

    Random random;
    RestClient depircatedApiClient;
    HttpClient httpClient;

    public Menu() {
        this.random = new Random();
        this.depircatedApiClient = new RestClient();
        this.httpClient = new HttpClient();
        mainMenu();
    }

    private void mainMenu() {
        while (true) {
            TextManager.mainMenu();
            switch (UserInputManager.getLimitedInt(1, 2)) {
                case 1 -> findPokemonMenu();
                case 2 -> {
                }//userMenu();
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
                    // todo remove JSONObject jsonPokemon = new JSONObject(pokemon);
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
