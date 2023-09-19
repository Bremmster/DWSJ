package com.karlson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Embeddable
public class PokemonType {

    private String slot;
    private String type;

    public PokemonType(String slot, String type) {
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
        return "PokemonType{" +
                "slot='" + slot + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
