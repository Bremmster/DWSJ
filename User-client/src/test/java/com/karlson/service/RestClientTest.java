package com.karlson.service;

import com.karlson.pokemondata.model.Pokemon;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RestClientTest {
    /**
     * Method under test: default or parameterless constructor of {@link RestClient}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     RestClient.objectMapper

        new RestClient();
    }

    /**
     * Method under test: {@link RestClient#sendMessage(Pokemon)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendMessage() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        RestClient restClient = null;
        Pokemon pokemon = null;

        // Act
        restClient.sendMessage(pokemon);

        // Assert
        // TODO: Add assertions on result
    }
}

