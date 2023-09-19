package com.karlson.converter;

import com.karlson.entity.Pokemon;
import com.karlson.entity.PokemonType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/*
@Component
public class PokemonTypeConverter {

    // lista med all data
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonTypeConverter.class);
    private static TypeRepository typeRepository;
    private static List<PokemonType> pokemonTypesDb;
    @Autowired
    public PokemonTypeConverter(TypeRepository typeRepository) {
        PokemonTypeConverter.typeRepository = typeRepository;
        pokemonTypesDb = typeRepository.findAll();
    }

    public static Pokemon typeConverter(Pokemon pokemon) {
     //   List<PokemonType> pokemonTypesDb = typeRepository.findAll();  // Hämta lista över typer från databas och förvara statiskt i minnen? eller ta ifrån config?
        String[] slot = new String[2];

        for (int i = 0; i < 2; i++) {
        slot[i] = pokemon.getTypes().get(i).getType(); // string
        }

        for (PokemonType dbType : pokemonTypesDb) {
            if (dbType.getType().equalsIgnoreCase(slot[0])) {
                pokemon.setFirstType((int) dbType.getId());
            }
            if ( slot[1] != null && dbType.getType().equalsIgnoreCase(slot[1])) {
                pokemon.setSecondType((int) dbType.getId());
            }
        }

        return pokemon;
    }

 */
