package com.karlson.controller;

import com.karlson.kafka.JsonKafkaProducer;
import com.karlson.pokemondata.model.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pokemons")
public class PokemonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public PokemonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Pokemon pokemon) {
        kafkaProducer.sendMessage(pokemon);
        System.out.println(pokemon);
        return ResponseEntity.ok("Message sent to topic");
    }
}
