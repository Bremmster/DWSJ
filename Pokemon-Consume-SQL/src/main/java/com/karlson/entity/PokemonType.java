package com.karlson.entity;

import jakarta.persistence.*;

@Entity
//@Table(name = "types")
public class PokemonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Transient
    private String slot; // TODO delete this
    private String type;

    @ManyToOne
    @JoinTable(name = "pokemons")
    private Pokemon pokemon;

    public PokemonType() {
    }

    public PokemonType(String slot, String type) {
        this.slot = slot; //  TODO delete this
        this.type = type;
    }

    public PokemonType(String type) {
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
    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
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
