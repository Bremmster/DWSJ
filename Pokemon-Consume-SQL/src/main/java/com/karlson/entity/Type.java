package com.karlson.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String slot; // TODO delete this
    public String type;

    public Type() {
    }

    public Type(String slot, String type) {
        this.slot = slot; //  TODO delete this
        this.type = type;
    }

    public Type(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // TODO delete
    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
// todo end

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", slot='" + slot + '\'' + // todo remove
                ", type='" + type + '\'' +
                '}';
    }
}
