package com.karlson.payload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pokemon {
    /*
   {
    "pokeId": "4",
    "name": "pika",
    "total": 210,
    "hp": 100,
    "attack": "50",
    "defence": "60",
    "types": [
        {
            "slot": 1,
            "type": "grass"
        },
        {
            "slot": 2,
            "type": "poison"
        }
    ]
}
     */
    public int pokeId;  // This is pokedex number
    public String name;
    public int total;
    public int hp;
    public int attack;
    public int defence;
    public List<Type> types;

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokeId=" + pokeId +
                ", name='" + name + '\'' +
                ", types=" + types +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
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

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
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
