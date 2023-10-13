package com.karlson.kafka;

import com.karlson.pokemondata.model.Pokemon;
import org.apache.kafka.common.errors.TimeoutException;
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

    private final KafkaTemplate<String, Pokemon> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Pokemon> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Pokemon data) throws TimeoutException {

        LOGGER.info("Atempting to send message -> %s ", data);

        Message<Pokemon> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "pokemons").build();

        try {
            kafkaTemplate.send(message);
        } catch (TimeoutException e) {
            LOGGER.warn("Timeout occurred while sending message to Kafka");
            throw new TimeoutException(e.toString());
        }
        LOGGER.info("Sent successfully");
    }
}
