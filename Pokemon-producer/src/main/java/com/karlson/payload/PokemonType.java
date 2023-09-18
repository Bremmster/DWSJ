package com.karlson.payload;

public class PokemonType {
    public int slot;
    public String type;
    
    @Override
    public String toString() {
        return "PokemonType{" +
                "slot=" + slot +
                ", type='" + type + '\'' +
                '}';
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
