package com.karlson;

import com.karlson.entity.Pokemon;
import com.karlson.entity.PokemonType;
import com.karlson.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatabaseTest {

    private static Pokemon pokemon;
    @Autowired
    private PokemonRepository pokemonRepository;

    @BeforeAll
    static void beforeAll() {
        List<PokemonType> types = new ArrayList<>();
        types.add(new PokemonType("first", "fire"));
        types.add(new PokemonType("second", "ice"));

        pokemon = new Pokemon(1, "Pika", 80, 30, 35, 35, types);
    }

    @Test
    void name() {

        pokemonRepository.save(pokemon);

        assertEquals(pokemon.getName(), pokemonRepository.findById(1L).get().getName());


    }
}
