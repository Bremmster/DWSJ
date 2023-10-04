package com.karlson.controller;

import static org.mockito.Mockito.doNothing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.kafka.JsonKafkaProducer;
import com.karlson.pokemondata.model.Pokemon;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PokemonMessageController.class})
@ExtendWith(SpringExtension.class)
class PokemonMessageControllerTest {
    @MockBean
    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    private PokemonMessageController pokemonMessageController;

    /**
     * Method under test: {@link PokemonMessageController#publish(Pokemon)}
     */
    @Test
    void testPublish() throws Exception {
        doNothing().when(jsonKafkaProducer).sendMessage(Mockito.<Pokemon>any());

        Pokemon pokemon = new Pokemon();
        pokemon.setAttack(1);
        pokemon.setDefence(1);
        pokemon.setHp(1);
        pokemon.setId(1L);
        pokemon.setName("Name");
        pokemon.setPokedexNumber(10);
        pokemon.setTypes(new ArrayList<>());
        pokemon.setTotal(1);
        String content = (new ObjectMapper()).writeValueAsString(pokemon);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/pokemons/publish")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(pokemonMessageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Message sent to topic"));
    }
}

