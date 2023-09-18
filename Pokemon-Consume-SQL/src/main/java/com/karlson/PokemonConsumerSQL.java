package com.karlson;

import com.karlson.entity.Pokemon;
import com.karlson.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class PokemonConsumerSQL implements CommandLineRunner {

    PokemonRepository pokemonRepository;

    @Autowired
    public PokemonConsumerSQL(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PokemonConsumerSQL.class);
    }

    @Override
    public void run(String... args) {
        System.out.println("Welcome");
        Optional<Pokemon> poke = this.pokemonRepository.findById(1L);
        System.out.println("Found");
        poke.ifPresent(pokemon -> System.out.println(pokemon.getName()));
        System.out.println("types");
        poke.ifPresent(pokemon -> System.out.println(pokemon.getTypes()));
    }


}
