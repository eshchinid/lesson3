package com.example.lesson3.AL.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonAL {
    private Integer id;
    private String name;

    public PersonAL(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonAL() {
    }
}
