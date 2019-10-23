package com.example.lesson3.JDBC.controller;

import com.example.lesson3.JDBC.model.PersonJDBC;
import com.example.lesson3.JDBC.repository.PersonJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("JDBC")
public class PersonJDBCController {

    private final PersonJDBCRepository personJDBCRepository;

    @Autowired
    public PersonJDBCController(PersonJDBCRepository personJDBCRepository) {
        this.personJDBCRepository = personJDBCRepository;
    }


    @GetMapping("/persons")
    public List<PersonJDBC> getAll(){
        return personJDBCRepository.findAll(); }


    @GetMapping("/persons/{id}")
    public PersonJDBC get(@PathVariable UUID id){
        return personJDBCRepository.getById(id); }

    @PostMapping("/person")
    public UUID create(@RequestBody PersonJDBC personJDBC){
        return personJDBCRepository.create(personJDBC); }

    @PutMapping("/person")
    public Boolean update(@RequestBody PersonJDBC user){
        return personJDBCRepository.update(user);
    }

    @DeleteMapping("/personDel/{id}")
    public Boolean delete(@PathVariable UUID id){
        return personJDBCRepository.delete(id);
    }

}
