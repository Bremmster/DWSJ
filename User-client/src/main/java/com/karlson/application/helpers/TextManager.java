package com.karlson.application.helpers;

import com.karlson.pokemondata.model.Pokemon;

public class TextManager {

    public static void pokemonNewName() {
        System.out.print("Set username: ");
    }

    public static void notValidInt() {
        System.out.print("Not an Integer\nPleaser enter Integer: ");
    }
    public static void notValidChoice() {
        System.out.println("Not a valid choice. Better luck next time \nPlease try again: ");
    }

    public static void mainMenu() {
        System.out.println("+---------------------------------------+");
        System.out.println("| Main menu                             |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Look for Pokémon                   |");
        System.out.println("| 2) <Not implemented>                  |");
        System.out.println("| 9) Exit                               |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }

    public static void findPokemon(Pokemon pokemon) {
        System.out.println("+---------------------------------------+");
        System.out.println("| You found:                            |");
        System.out.println("| " + pokemon.toString());
        System.out.println("| 1: Set name and send to API           |");
        System.out.println("| 9: Return to main menu                |");
        System.out.println("+---------------------------------------+");
    }

    public void notValidData() {
        System.out.println("Sorry i wont allow that");
    }

}
