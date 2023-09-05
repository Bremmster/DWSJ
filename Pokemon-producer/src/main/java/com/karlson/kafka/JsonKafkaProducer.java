package com.karlson.kafka;

import com.karlson.payload.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    public static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Pokemon> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Pokemon> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Pokemon data) {

        LOGGER.info(String.format("Message sent -> %s ", data.toString()));

        Message<Pokemon> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "pokemons").build();

        kafkaTemplate.send(message);
    }
}
