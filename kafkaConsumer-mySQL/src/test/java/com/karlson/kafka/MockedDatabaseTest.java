package com.karlson.kafka;

import com.karlson.pokemondata.model.Pokemon;
import com.karlson.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MockedDatabaseTest {

    @Autowired
    private PokemonRepository pokemonRepository;
    private Pokemon pokemon;

    @BeforeEach
    void setUp() {
        pokemon = new Pokemon("h2Test", new Random());
    }

    @Test
    void savePokemonTest() {

        // Given hanteras i @BeforeAll
        // When
        Pokemon savedPokemon = pokemonRepository.save(pokemon);
        // Then
        assertThat(savedPokemon).isNotNull();
        assertThat(savedPokemon.getId()).isGreaterThan(0);
    }

    @Test
    void updatePokemonTest() {

        pokemonRepository.save(pokemon);

        // When
        Pokemon savedPokemon = pokemonRepository.findById(pokemon.getId()).get();
        savedPokemon.setName("updatedName");

        Pokemon updatedPokemon = pokemonRepository.save(savedPokemon);
        // Then
        assertThat(updatedPokemon.getName()).isEqualTo("updatedName");
    }

    @Test
    void deletePokemonTest() {

        pokemonRepository.save(pokemon);
        // When
        pokemonRepository.deleteById(pokemon.getId());
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(pokemon.getId());
        // Then
        assertThat(optionalPokemon).isEmpty();
    }
}
