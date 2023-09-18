package com.karlson;

import com.karlson.entity.Pokemon;
import com.karlson.entity.PokemonType;
import com.karlson.repository.PokemonRepository;
import com.karlson.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class PokemonConsumerSQL { //implements CommandLineRunner {

    PokemonRepository pokemonRepository;
    TypeRepository typeRepository;

    public PokemonConsumerSQL(PokemonRepository pokemonRepository, TypeRepository typeRepository) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
    }

    @Autowired


    public static void main(String[] args) {
        SpringApplication.run(PokemonConsumerSQL.class);
    }
/*
    @Override
    public void run(String... args) {
        System.out.println("Welcome");
        Optional<Pokemon> poke = this.pokemonRepository.findById(1L);
        poke.ifPresent(pokemon -> System.out.println(pokemon.getName()));
        System.out.println("done");
        Optional<PokemonType> type = this.typeRepository.findById(1L);
        for (PokemonType pType: poke.get().getTypes() ) {
            System.out.println(pType.getType());

        }
       // poke.ifPresent(pokemon -> System.out.println(pokemon.getTypes()));
    }

 */


}
