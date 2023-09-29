package com.karlson.pokemondata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.karlson.pokemondata.util.GivePokemonType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int pokedexNumber;
    private String name;
    private int total;
    private int hp;
    private int attack;
    private int defence;
    @JsonProperty("types")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "pokemon_types")
    private List<PokemonType> pokemonTypes;

    public Pokemon() {
    }

    public Pokemon(int pokedexNumber, String name, int total, int hp, int attack, int defence, List<PokemonType> pokemonTypes) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.pokemonTypes = pokemonTypes;
    }

    public Pokemon(String name, Random random) { // to generate new pokemons in the user client
        this.pokedexNumber = random.nextInt(1, 1010 + 1);
        this.name = name;
        this.hp = random.nextInt(0, 100);
        this.attack = random.nextInt(0, 100);
        this.defence = random.nextInt(0, 100);
        this.total = attack + defence + hp;

        this.pokemonTypes = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            pokemonTypes.add(new PokemonType((i == 0 ? "first" : "second"), GivePokemonType.get(random)));
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String toPrettyString() {
        return "pokedex number: " + pokedexNumber +
                "\nname: " + name +
                "\ntotal: " + total +
                "\nhp: " + hp +
                "\nattack: " + attack +
                "\ndefence: " + defence +
                "\ntypes: " + pokemonTypes;
    }
}
