package com.karlson.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.pokemondata.model.Pokemon;
import com.karlson.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
class KafkaConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    private final PokemonRepository pokemonRepository;
    private final ObjectMapper objectMapper;


    @Autowired
    public KafkaConsumer(PokemonRepository pokemonRepository, ObjectMapper objectMapper) {
        this.pokemonRepository = pokemonRepository;
        this.objectMapper = objectMapper;
    }




    @KafkaListener(topics = "WRONG", groupId = "myGroup") // change name of topic
    public void consumeString(String message) {

        try {
            Pokemon pokemon = objectMapper.readValue(message, Pokemon.class);

            pokemonRepository.save(pokemon);
            LOGGER.info(String.format("Message received -> %s", pokemon));

        } catch (JsonProcessingException e) {
            LOGGER.error("Error processing Kafka message:  {}", e.getMessage());
            throw new RuntimeException("Error processing Kafka message ", e);
        }
    }


    @KafkaListener(topics = "pokemons", groupId = "myGroup")
    public void consumeJson(Pokemon pokemon) {

        try {
            pokemonRepository.save(pokemon);
            LOGGER.info(String.format("Message received -> %s", pokemon));
        } catch (Exception e) {
            LOGGER.error("Error processing Kafka message:  {}", e.getMessage());
            throw new RuntimeException("Error processing Kafka message ", e);
        }
    }


}
