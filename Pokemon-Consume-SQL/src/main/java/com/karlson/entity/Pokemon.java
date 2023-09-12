package com.karlson.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1 example @JsonProperty("Id")
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue
    private long id;
    private int pokeId;
    private String name;
    private int total;
    private int hp;
    private int attack;
    private int defence;
    @OneToMany
    @JoinColumn(name = "type", referencedColumnName = "id")
    private List<Type> types = new ArrayList<>() {
    };
}



