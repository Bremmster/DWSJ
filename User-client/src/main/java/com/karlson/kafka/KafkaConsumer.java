package com.karlson.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karlson.pokemondata.model.Pokemon;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class KafkaConsumer {

    private static final String TOPIC_NAME = "pokemons";
    private static Properties properties;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumer() {
        properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "fetchingGroup");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.springframework.kafka.support.serializer.JsonDeserializer");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put("spring.json.trusted.packages", "*");
    }

    public void getKafkaData(Boolean reset) {
//        List<Pokemon> pokemonList = new ArrayList<>();

        Consumer<String, Pokemon> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(properties);

        consumer.assign(Collections.singletonList(new TopicPartition(TOPIC_NAME, 0)));

        if (Boolean.TRUE.equals(reset)) {
            consumer.seekToBeginning(consumer.assignment());
        }

        ConsumerRecords<String, Pokemon> records = consumer.poll(Duration.ofMillis(100));
        for (ConsumerRecord<String, Pokemon> consumerRecord : records) {
            System.out.println(consumerRecord.value());
        }
        consumer.close();
    }
}
