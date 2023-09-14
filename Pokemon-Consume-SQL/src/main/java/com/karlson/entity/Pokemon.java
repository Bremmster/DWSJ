package com.karlson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1 example @JsonProperty("Id")
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int pokeId;
    private String name;
    private int total;
    private int hp;
    private int attack;
    private int defence;
    @JsonProperty("types")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //todo this will stick with TYPE A +B or something
    @JoinColumn(name = "pokeId", referencedColumnName = "pokeId")
    @Transient
    private List<Type> types;
    @JsonIgnore
    private int typeA;
    @JsonIgnore
    private int typeB;

    public Pokemon() {
    }

    public Pokemon(int pokeId, String name, int total, int hp, int attack, int defence, List<Type> types) {
        this.pokeId = pokeId;
        this.name = name;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.types = types;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPokeId() {
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

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) { // todo here make the list write to slot A+B
        this.types = types;
    }

    @Override
    public String toString() { // todo update this when list changes is done
        return "Pokemon found!{" +
                "id=" + id +
                ", pokeId=" + pokeId +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", types=" + types +
                '}';
    }
}



