package com.example.lesson3.JDBC.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PersonJDBC {
    private UUID id;
    private String name;
    private String email;
    private String phone;

    public PersonJDBC() {
    }

    public PersonJDBC(UUID id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public PersonJDBC(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
