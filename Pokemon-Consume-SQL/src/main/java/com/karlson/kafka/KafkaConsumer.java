package com.karlson.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.config.PokemonTypeConfig;
import com.karlson.coverter.PokemonTypeConverter;
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


    private final PokemonRepository pokemonRepository;
    private final ObjectMapper objectMapper;

    private PokemonTypeConverter pokemonTypeConverter;

    @Autowired
    public KafkaConsumer(PokemonRepository pokemonRepository, ObjectMapper objectMapper, PokemonTypeConverter pokemonTypeConverter) {
        this.pokemonRepository = pokemonRepository;
        this.objectMapper = objectMapper;
        this.pokemonTypeConverter = pokemonTypeConverter;
    }



    @KafkaListener(topics = "pokemons", groupId = "myGroup")
    public void consume(String message) {

        try {
            Pokemon pokemon = objectMapper.readValue(message, Pokemon.class);
            System.out.println("to string" + pokemon.toString());

            // Här ska man konvertera
            pokemon = pokemonTypeConverter.typeConverter(pokemon);

            pokemonRepository.save(pokemon);
            LOGGER.info(String.format("Message received -> %s", pokemon.toString()));

        } catch (JsonProcessingException e) {
            LOGGER.error("Error processing Kafka message:  {}", e.getMessage());
            throw new RuntimeException("Error processing Kafka message ", e);
        }


//        LOGGER.info(String.format("Message received -> %s", message));

    }
}
