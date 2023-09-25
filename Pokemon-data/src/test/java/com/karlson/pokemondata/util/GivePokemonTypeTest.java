package com.karlson.pokemondata.util;

import java.util.Random;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class GivePokemonTypeTest {
    /**
     * Method under test: {@link GivePokemonType#get(Random)}
     */
    @Test
    void testGet() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     Random.haveNextNextGaussian
        //     Random.nextNextGaussian
        //     Random.seed

        GivePokemonType.get(new Random());
    }

    /**
     * Method under test: {@link GivePokemonType#get(Random)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGet2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Random.nextInt(int)" because "random" is null
        //       at com.karlson.pokemondata.util.GivePokemonType.get(GivePokemonType.java:12)
        //   See https://diff.blue/R013 to resolve this issue.

        GivePokemonType.get(null);
    }
}

