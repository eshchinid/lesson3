package com.example.lesson3.JPA.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.UUID;


//класс модели с валидаторами

@Entity
@Table(name = "personjpa")
@Data
public class PersonJPA {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(insertable = false)
    private UUID id;
    @Pattern(regexp="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    private String name;
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$")
    private String phone;
    @Email
    private String email;

}
