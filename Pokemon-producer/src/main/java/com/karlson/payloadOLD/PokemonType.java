package com.karlson.payloadOLD;
@Deprecated
public class PokemonType {
    public String slot;
    public String type;

    @Override
    public String toString() {
        return "PokemonType{" +
                "slot=" + slot +
                ", type='" + type + '\'' +
                '}';
    }

    public PokemonType(String slot, String type) {
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
}
