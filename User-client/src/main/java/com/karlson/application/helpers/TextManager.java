package com.karlson.application.helpers;

import com.karlson.pokemondata.model.Pokemon;

import java.util.List;

public class TextManager {

    private static final String TOP_BORDER = "+--------------------------------------------+";

    public static void notValidInt() {
        System.out.print("Not an Integer\nPleaser enter Integer: ");
    }

    public static void timeOut() {
        System.out.println("Timeout for restAPI is 60 sec have patience");
    }

    public static void notValidChoice() {
        System.out.println("Not a valid choice. Better luck next time \nPlease try again: ");
    }

    public static void mainMenu() {
        System.out.println(TOP_BORDER);
        System.out.println("| Main menu                                  |");
        System.out.println(TOP_BORDER);
        System.out.println("| 1) Look for Pokémon                        |");
        System.out.println("| 2) Get all new messages from other sources |");
        System.out.println("| 3) Reset Kafka consumer, get all messages  |");
        System.out.println("| 9) Exit                                    |");
        System.out.println(TOP_BORDER);
        System.out.print("Enter a option: ");
    }

    public static void findPokemon(Pokemon pokemon) {
        System.out.println(TOP_BORDER);
        System.out.println("| You found:                                 |");
        System.out.println("| " + pokemon.toPrettyString());
        System.out.println("| 1: Set name and send to API                |");
        System.out.println("| 9: Return to main menu                     |");
        System.out.println(TOP_BORDER);
        System.out.print("Enter a option: ");
    }

    public static void viewPokemons(List<Pokemon> pokemons) {
        System.out.println(TOP_BORDER);
        System.out.println("Message from Kafka broker: ");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.toPrettyString());
            System.out.println(TOP_BORDER);
        }
    }

    public void notValidData() {
        System.out.println("Sorry i wont allow that");
    }
}
