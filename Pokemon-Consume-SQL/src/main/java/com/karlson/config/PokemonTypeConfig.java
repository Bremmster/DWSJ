package com.karlson.config;
/*
import com.karlson.entity.PokemonType;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PokemonTypeConfig {

    public static final Logger LOGGER = LoggerFactory.getLogger(PokemonTypeConfig.class);
    private final String[] POKETYPES = {"normal", "fire", "water", "grass", "electric", "ice", "fighting",
            "poison", "ground", "flying", "psychic", "bug", "rock", "ghost", "dragon", "dark", "steel", "fairy"};
    private final TypeRepository typeRepository;

    @Autowired
    public PokemonTypeConfig(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * Add all Pokémon types to a database table
     **/
/*
    @PostConstruct
    private void createTypeTable() {
        List<PokemonType> dbPokemonTypes = typeRepository.findAll();


        for (String type : POKETYPES) {
            if (!typeExists(dbPokemonTypes, type)) {
                LOGGER.info("Not found in list adding " + type);
                try {
                    typeRepository.save(new PokemonType(type));
                } catch (Exception e) {
                    LOGGER.error("Error while adding type: " + e.getMessage());
                }
            }
        }
    }

    private boolean typeExists(List<PokemonType> pokemonTypes, String typeName) {
        return pokemonTypes.stream().anyMatch(pokemonType -> pokemonType.getType().equalsIgnoreCase(typeName));
    }
}
*/