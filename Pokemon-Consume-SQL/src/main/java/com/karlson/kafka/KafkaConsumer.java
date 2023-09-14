package com.karlson.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.entity.Pokemon;
import com.karlson.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

@Service
class KafkaConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    private PokemonRepository pokemonRepository;
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "pokemons", groupId = "myGroup")
    public void consume(String message) {

        
        Pokemon pokemon;
        try {
            pokemon = om.readValue(message, Pokemon.class);
            pokemonRepository.save(pokemon);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info(String.format("Message received -> %s", pokemon.toString()));


//        LOGGER.info(String.format("Message received -> %s", message));

    }
}
