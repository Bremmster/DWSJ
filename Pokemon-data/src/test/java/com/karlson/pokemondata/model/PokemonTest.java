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

    /**
     * Method under test: {@link Pokemon#Pokemon(String, Random)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Random.nextInt(int, int)" because "random" is null
        //       at com.karlson.pokemondata.model.Pokemon.<init>(Pokemon.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        new Pokemon("Name", null);

    }
}

