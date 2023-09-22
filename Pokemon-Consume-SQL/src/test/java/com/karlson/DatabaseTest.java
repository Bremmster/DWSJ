package com.karlson;

import com.karlson.pokemondata.model.*;
import com.karlson.repository.PokemonRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "/application-test.properties")
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
    @Order(1)
    void createPokemonTest() {

        pokemon = pokemonRepository.save(pokemon);

        assertNotNull(pokemonRepository.findById(pokemon.getId()).get());
    }

    @Test
    @Order(2)
    void updatePokemonTest() {

        Pokemon fetchedPokemon = pokemonRepository.findById(pokemon.getId()).get();
        assertNotNull(fetchedPokemon);

        fetchedPokemon.setName("Ditto");

        pokemonRepository.save(fetchedPokemon);

        assertEquals("Ditto", pokemonRepository.findById(pokemon.getId()).get().getName());

    }

    @Test
    @Order(3)
    void deletePokemon() {
        assertNotNull(pokemonRepository.findById(pokemon.getId()).get());

        pokemonRepository.deleteById(pokemon.getId());

        assertTrue(pokemonRepository.findById(pokemon.getId()).isEmpty());
    }
}
