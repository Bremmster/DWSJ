package com.karlson.kafka;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.karlson.pokemondata.model.Pokemon;
import com.karlson.repository.PokemonRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {KafkaConsumer.class})
@ExtendWith(SpringExtension.class)
class KafkaConsumerTest {
    @Autowired
    private KafkaConsumer kafkaConsumer;

    @MockBean
    private PokemonRepository pokemonRepository;

    /**
     * Method under test: {@link KafkaConsumer#consumeJson(Pokemon)}
     */
    @Test
    void testConsumeJson() {
        Pokemon pokemon = new Pokemon();
        pokemon.setAttack(1);
        pokemon.setDefence(1);
        pokemon.setHp(1);
        pokemon.setId(1L);
        pokemon.setName("Name");
        pokemon.setPokedexNumber(10);
        pokemon.setTypes(new ArrayList<>());
        pokemon.setTotal(1);
        when(pokemonRepository.save(Mockito.<Pokemon>any())).thenReturn(pokemon);

        Pokemon pokemon2 = new Pokemon();
        pokemon2.setAttack(1);
        pokemon2.setDefence(1);
        pokemon2.setHp(1);
        pokemon2.setId(1L);
        pokemon2.setName("Name");
        pokemon2.setPokedexNumber(10);
        pokemon2.setTypes(new ArrayList<>());
        pokemon2.setTotal(1);
        kafkaConsumer.consumeJson(pokemon2);
        verify(pokemonRepository).save(Mockito.<Pokemon>any());
    }
}

