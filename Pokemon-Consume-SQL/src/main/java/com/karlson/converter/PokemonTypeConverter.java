package com.karlson.converter;

import com.karlson.entity.Pokemon;
import com.karlson.entity.PokemonType;
import com.karlson.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        String[] slot = new String[2];

        for (int i = 0; i < 2; i++) {
        slot[i] = pokemon.getTypes().get(i).getType(); // string

        }
        // String slotA = pokemon.getTypes().get(1).getType(); // string

        // jämför värden
        for (PokemonType dbType : pokemonTypesDb) {
            if (dbType.getType().equalsIgnoreCase(slot[0])) {
                pokemon.setTypeA((int) dbType.getId());
            }
            if (dbType.getType().equalsIgnoreCase(slot[1])) {
                pokemon.setTypeB((int) dbType.getId());
            }
        }
        return pokemon;
    }
}