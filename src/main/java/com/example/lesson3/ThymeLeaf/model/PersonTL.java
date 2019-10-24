package com.example.lesson3.ThymeLeaf.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "persontl")
public class PersonTL {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String email;

    public PersonTL() {
    }

    public PersonTL(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
