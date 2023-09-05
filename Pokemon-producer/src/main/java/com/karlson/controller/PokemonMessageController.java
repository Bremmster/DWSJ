package com.karlson.controller;

import com.karlson.kafka.JsonKafkaProducer;
import com.karlson.payload.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pokemons")
public class PokemonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public PokemonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/pubilsh")
    public ResponseEntity<String> publish(@RequestParam Pokemon payload) {
        kafkaProducer.sendMessage(payload);

        return ResponseEntity.ok("Message sent to topic");
    }
}
