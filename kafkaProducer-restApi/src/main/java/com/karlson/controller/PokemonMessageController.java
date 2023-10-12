package com.karlson.controller;

import com.karlson.kafka.JsonKafkaProducer;
import com.karlson.pokemondata.model.Pokemon;
import org.apache.kafka.common.errors.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pokemons")
public class PokemonMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonMessageController.class);
    private final JsonKafkaProducer kafkaProducer;

    public PokemonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Pokemon pokemon) {

        try {
            kafkaProducer.sendMessage(pokemon);
        } catch (TimeoutException e) {
            LOGGER.warn("Kafka topic is down!");
            return ResponseEntity.ofNullable("500");
        }
        return ResponseEntity.ok("Message sent to topic");
    }
}
