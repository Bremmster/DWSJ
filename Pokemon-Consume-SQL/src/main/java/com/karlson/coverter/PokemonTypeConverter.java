package com.karlson.coverter;

import com.karlson.entity.Pokemon;
import com.karlson.entity.PokemonType;
import com.karlson.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PokemonTypeConverter {

    // lista med all data
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonTypeConverter.class);
    private TypeRepository typeRepository;

    @Autowired
    public PokemonTypeConverter(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Pokemon typeConverter(Pokemon pokemon) { // ta emot en pokemon
        List<PokemonType> pokemonTypesDb = typeRepository.findAll();  // Hämta lista över typer från databas och förvara statiskt i minnen? eller ta ifrån config?

        String slotA = pokemon.getTypes().get(0).getType(); // string
        String slotB = pokemon.getTypes().get(1).getType(); // string

        // jämför värden
        for (PokemonType type : pokemonTypesDb) {
            if (type.getType().equalsIgnoreCase(slotA)) {
                pokemon.setTypeA((int) type.getId());
            }
            if (type.getType().equalsIgnoreCase(slotB)) {
                pokemon.setTypeB((int) type.getId());
            }
        }
        return pokemon;
    }
}