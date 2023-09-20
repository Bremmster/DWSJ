package com.karlson.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pokemon {

    private long id;
    public int pokeId;  // This is pokédex number
    public String name;
    public int total;
    public int hp;
    public int attack;
    public int defence;
    @JsonProperty("types")
    public List<PokemonType> pokemonTypes;

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokeId=" + pokeId +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", pokemonTypes=" + pokemonTypes +
                '}';
    }

    public long getPokeId() {
        return pokeId;
    }

    public void setPokeId(int pokeId) {
        this.pokeId = pokeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonType> getPokemonTypes() {
        return pokemonTypes;
    }

    public void setPokemonTypes(List<PokemonType> pokemonPokemonTypes) {
        this.pokemonTypes = pokemonPokemonTypes;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
