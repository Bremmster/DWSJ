package com.karlson.payload;

import java.util.Arrays;

public class Pokemon {
    /*
    {
"Id":"integer",
"Name":"String",
"Type":["String", "String"],
"Total":"integer",
"HP":"integer",
"Attack":"integer",
"Defense":"integer"
}
     */
    private long id;  // Ponder if this is pokedex number or db key
    private String name;
    private String[] type;
    private int total;
    private int hp;
    private int attack;
    private int defence;

    @Override
    public String toString() {  // Output is Json formatted
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + Arrays.toString(type) +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
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
