package com.example.lesson3.AL.controller;


import com.example.lesson3.AL.model.PersonAL;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class PersonALController {
    private final List<PersonAL> list = new ArrayList<>();

    @GetMapping("/person")
    public List<PersonAL> getAll(){
        return list;
    }

    @PostMapping("/person")
    public String create(@RequestBody PersonAL personAL){
        list.add(personAL);
        return "Add";
    }

//    не работает

    @GetMapping("/person/1/{id}")
    public PersonAL findByid1 (@PathVariable Integer id, List<PersonAL> persons) {
        for (PersonAL personAL : persons) {
            if (personAL.getId().equals(id)){
                return personAL;
            }
        }
        return null;
    }

//    не работает

    @GetMapping("/person/2/{id}")
    public PersonAL findById2 (@PathVariable Integer id) {
        PersonAL personAL = list.stream()
                .filter(person -> "id".equals(person.getId()))
                .findAny()
                .orElse(null);
        return personAL;
    }

//    не работает

    @GetMapping("/person/{name}")
    public PersonAL findByName (@PathVariable String name, List<PersonAL> customers) {
        Iterator<PersonAL> iterator = customers.iterator();
        while (iterator.hasNext()) {
            PersonAL person = iterator.next();
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }






//    @GetMapping("/person/{id}")
//    public Optional<PersonAL> get(@PathVariable UUID id){
//        return .findById(id);
//    }
//
//
//
//
//    @DeleteMapping("/person/{id}")
//    public void delete(@PathVariable UUID id){
//        .deleteById(id);
//    }
//
}
