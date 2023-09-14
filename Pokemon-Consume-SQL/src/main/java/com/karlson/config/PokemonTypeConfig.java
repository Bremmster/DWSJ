package com.karlson.config;

import com.karlson.entity.Type;
import com.karlson.repository.TypeRepository;
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
            "poison", "ground", "rock", "psychic", "ice", "bug", "ghost", "steel", "dragon", "dark", "fairy"};
    TypeRepository typeRepository;

    @Autowired
    public PokemonTypeConfig(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * Add all Pokémon types to a database table
     */
    @PostConstruct
    private void createTypeTable() {
        List<Type> dbTypes = typeRepository.findAll();


        for (String type : POKETYPES) {
            if (!typeExists(dbTypes, type)) {
                LOGGER.info("Not found in list adding " + type);
                try {
                    typeRepository.save(new Type(type));
                } catch (Exception e) {
                    LOGGER.error("Error while adding type: " + e.getMessage());
                }
            }
/*
            boolean found;
            found = false;
            for (Type prop : dbTypes) {
                if (prop.getType().equalsIgnoreCase(type)) {
                    System.out.println("found in list");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Not found in list adding " + type);
                this.typeRepository.save(new Type(type));
            } */
        }
    }

    private boolean typeExists(List<Type> types, String typeName) {
        return types.stream().anyMatch(type -> type.getType().equalsIgnoreCase(typeName));
    }
}
