package com.karlson.service;

import com.karlson.pokemondata.model.Pokemon;
import com.karlson.pokemondata.model.PokemonType;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class HttpClientTest {
    /**
     * Method under test: {@link HttpClient#post(Pokemon)}
     */
    @Test
    void testPostToWebAPI() {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenReturn(new InetAddress[]{mock(InetAddress.class)});
            HttpClient httpClient = new HttpClient();
            Pokemon pokemon = mock(Pokemon.class);
            when(pokemon.getAttack()).thenReturn(1);
            when(pokemon.getDefence()).thenReturn(1);
            when(pokemon.getHp()).thenReturn(1);
            when(pokemon.getPokedexNumber()).thenReturn(10);
            when(pokemon.getTotal()).thenReturn(1);
            when(pokemon.getName()).thenReturn("Name");
            when(pokemon.getId()).thenReturn(1L);
            doNothing().when(pokemon).setAttack(anyInt());
            doNothing().when(pokemon).setDefence(anyInt());
            doNothing().when(pokemon).setHp(anyInt());
            doNothing().when(pokemon).setId(anyLong());
            doNothing().when(pokemon).setName(Mockito.<String>any());
            doNothing().when(pokemon).setPokedexNumber(anyInt());
            doNothing().when(pokemon).setTypes(Mockito.<List<PokemonType>>any());
            doNothing().when(pokemon).setTotal(anyInt());
            pokemon.setAttack(1);
            pokemon.setDefence(1);
            pokemon.setHp(1);
            pokemon.setId(1L);
            pokemon.setName("Name");
            pokemon.setPokedexNumber(10);
            pokemon.setTypes(new ArrayList<>());
            pokemon.setTotal(1);
            assertThrows(RuntimeException.class, () -> httpClient.post(pokemon));
            verify(pokemon).getAttack();
            verify(pokemon).getDefence();
            verify(pokemon).getHp();
            verify(pokemon).getPokedexNumber();
            verify(pokemon).getTotal();
            verify(pokemon).getName();
            verify(pokemon).getId();
            verify(pokemon).setAttack(anyInt());
            verify(pokemon).setDefence(anyInt());
            verify(pokemon).setHp(anyInt());
            verify(pokemon).setId(anyLong());
            verify(pokemon).setName(Mockito.<String>any());
            verify(pokemon).setPokedexNumber(anyInt());
            verify(pokemon).setTypes(Mockito.<List<PokemonType>>any());
            verify(pokemon).setTotal(anyInt());
        }
    }
}

