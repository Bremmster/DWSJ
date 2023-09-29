package com.karlson.pokemondata.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PokemonType {
    private String slot;
    private String type;

    public PokemonType(String slot, String type) {
        this.slot = slot;
        this.type = type;
    }

    public PokemonType() {
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "slot: " + slot + ", type: " + type;
    }
}
