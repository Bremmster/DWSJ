package com.karlson.model;

import com.karlson.util.Types;

public class PokemonType {
    private final String slot;
    private final String type;

    protected PokemonType(String slot, String type) {
        this.slot = slot;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PokemonType{" +
                "slot=" + slot +
                ", type='" + type + '\'' +
                '}';
    }
}
