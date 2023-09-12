package com.karlson.payload;

public class Type {
    public int slot;
    public String type;

    @Override
    public String toString() {
        return "Type{" +
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
