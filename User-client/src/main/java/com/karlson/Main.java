package com.karlson;

import com.karlson.model.Pokemon;
import com.karlson.service.RestClient;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("Hello, world!");
        Random random = new Random();

        // skapa typer
        Pokemon pokemon = new Pokemon("test", random);

        System.out.println(pokemon);
        RestClient client = new RestClient();
        client.sendMessage(pokemon);


        // fråga om namn

        // fråga användare om skicka till api

        // skicka till api
    }
}