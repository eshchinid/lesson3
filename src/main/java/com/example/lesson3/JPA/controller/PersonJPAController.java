package com.example.lesson3.JPA.controller;

import com.example.lesson3.JPA.model.PersonJPA;
import com.example.lesson3.JPA.repository.PersonJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("JPA")
public class PersonJPAController {

    private final PersonJPARepository personJPARepository;

    @Autowired
    public PersonJPAController(PersonJPARepository personJPARepository) {
        this.personJPARepository = personJPARepository;
    }

    @GetMapping("/person")
    public Iterable<PersonJPA> getAll(){
        return personJPARepository.findAll();
    }


    @GetMapping("/person/{id}")
    public Optional<PersonJPA> get(@PathVariable UUID id){
        return personJPARepository.findById(id);
    }


    @PostMapping("/person")
    public PersonJPA create(@RequestBody PersonJPA personJPA){
        return personJPARepository.save(personJPA);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable UUID id){
        personJPARepository.deleteById(id);
    }



}
