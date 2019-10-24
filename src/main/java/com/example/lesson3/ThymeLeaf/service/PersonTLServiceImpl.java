package com.example.lesson3.ThymeLeaf.service;

import com.example.lesson3.ThymeLeaf.model.PersonTL;
import com.example.lesson3.ThymeLeaf.repository.PersonTLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonTLServiceImpl implements PersonTLService {

    @Autowired
    private PersonTLRepository personRepository;


    @Override
    public PersonTL createPerson(PersonTL person) {
        return personRepository.save(person);
    }

    @Override
    public PersonTL getPerson(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public PersonTL editPerson(PersonTL person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(PersonTL person) {
        personRepository.delete(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<PersonTL> getAllPersons() {
        return personRepository.findAll();
    }


}
