package com.karlson.kafka;


import com.karlson.pokemondata.model.Pokemon;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class KafkaConsumer {

    private static final String TOPIC_NAME = "pokemons";
    private final Properties properties;

    public KafkaConsumer() {
        properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "fetchingGroup");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        properties.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put("spring.json.trusted.packages", "*");
    }

    public List<Pokemon> getKafkaData(Boolean reset) {
        List<Pokemon> pokemonList = new ArrayList<>();

        Consumer<String, Pokemon> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(properties);
        consumer.assign(Collections.singletonList(new TopicPartition(TOPIC_NAME, 0)));

        if (Boolean.TRUE.equals(reset)) {
            consumer.seekToBeginning(consumer.assignment());
        }
        ConsumerRecords<String, Pokemon> records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord<String, Pokemon> consumerRecord : records) {
            pokemonList.add(consumerRecord.value());
        }
        consumer.close();

        return pokemonList;
    }
}
