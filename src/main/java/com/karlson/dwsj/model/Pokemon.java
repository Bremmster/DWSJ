package com.karlson.dwsj.model;

import com.karlson.dwsj.util.GivePokemonType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon {

    private int pokedexNumber;
    private String name;
    private int total;
    private int hp;
    private int attack;
    private int defence;
    private List<PokemonType> pokemonTypes;

    public Pokemon() {
    }

    public Pokemon(String name, Random random) {
        this.pokedexNumber = random.nextInt(1, 1010 + 1);
        this.name = name;
        this.hp = random.nextInt(0, 100);
        this.attack = random.nextInt(0, 100);
        this.defence = random.nextInt(0, 100);
        this.total = attack + defence + hp;

        this.pokemonTypes = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            pokemonTypes.add(new PokemonType((i == 0 ? "first": "second" ), GivePokemonType.get(random)));
        }
    }
    
    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<PokemonType> getPokemonTypes() {
        return pokemonTypes;
    }

    public void setPokemonTypes(List<PokemonType> pokemonTypes) {
        this.pokemonTypes = pokemonTypes;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokedexNumber=" + pokedexNumber +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", pokemonTypes=" + pokemonTypes +
                '}';
    }
}
