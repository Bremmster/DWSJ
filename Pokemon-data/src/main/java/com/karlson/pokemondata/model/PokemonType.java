package com.karlson.pokemondata.model;

import jakarta.persistence.*;
@Embeddable
public class PokemonType {
    private final String slot;
    private final String type;

    protected PokemonType(String slot, String type) {
        this.slot = slot;
        this.type = type;
    }

    public String getSlot() {
        return slot;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PokemonType{" +
                "slot=" + slot +
                ", type='" + type + '\'' +
                '}';
    }
}
