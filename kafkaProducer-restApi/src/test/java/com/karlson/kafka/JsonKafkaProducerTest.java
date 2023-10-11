package com.karlson.kafka;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.karlson.pokemondata.model.Pokemon;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JsonKafkaProducer.class})
@ExtendWith(SpringExtension.class)
class JsonKafkaProducerTest {
    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @MockBean
    private KafkaTemplate<String, Pokemon> kafkaTemplate;

    /**
     * Method under test: {@link JsonKafkaProducer#sendMessage(Pokemon)}
     */
    @Test
    void testSendMessage() {
        when(kafkaTemplate.send(Mockito.<Message<Object>>any())).thenReturn(new CompletableFuture<>());

        Pokemon data = new Pokemon();
        data.setAttack(1);
        data.setDefence(1);
        data.setHp(1);
        data.setId(1L);
        data.setName("Name");
        data.setPokedexNumber(10);
        data.setTypes(new ArrayList<>());
        data.setTotal(1);
        jsonKafkaProducer.sendMessage(data);
        verify(kafkaTemplate).send(Mockito.<Message<Object>>any());
    }
}

