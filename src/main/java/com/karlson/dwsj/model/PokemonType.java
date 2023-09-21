package com.karlson.dwsj.model;

import com.karlson.dwsj.util.Types;

public class PokemonType {
    private String slot;
    private String type;

    protected PokemonType(String slot, String type) {
        this.slot = slot;
        this.type = type;
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
        return "PokemonType{" +
                "slot=" + slot +
                ", type='" + type + '\'' +
                '}';
    }
}
