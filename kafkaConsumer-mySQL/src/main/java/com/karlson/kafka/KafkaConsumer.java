package com.karlson.kafka;

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

    @Autowired
    public KafkaConsumer(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @KafkaListener(topics = "pokemons", groupId = "myGroup")
    public void consumeJson(Pokemon pokemon) {

        pokemonRepository.save(pokemon);

        LOGGER.info(String.format("Message received -> %s", pokemon));
    }
}
