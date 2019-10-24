package com.example.lesson3.ThymeLeaf.service;

import com.example.lesson3.ThymeLeaf.model.PersonTL;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface PersonTLService {
    PersonTL createPerson(PersonTL person);

    PersonTL getPerson(Long id);

    PersonTL editPerson(PersonTL person);

    void deletePerson(PersonTL person);

    void deletePerson(Long id);

    List<PersonTL> getAllPersons();


}
