package com.karlson.pokemondata.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class PokemonTest {
    /**
     * Method under test: {@link Pokemon#Pokemon(String, Random)}
     */
    @Test
    void testConstructor() {
        Pokemon actualPokemon = new Pokemon("Name", new Random());

        List<PokemonType> pokemonTypes = actualPokemon.getPokemonTypes();
        assertEquals(2, pokemonTypes.size());
        assertEquals("Name", actualPokemon.getName());
        assertEquals("first", pokemonTypes.get(0).getSlot());
        assertEquals("second", pokemonTypes.get(1).getSlot());
    }
}

