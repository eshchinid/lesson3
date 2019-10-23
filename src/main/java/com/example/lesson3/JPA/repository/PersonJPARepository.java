package com.example.lesson3.JPA.repository;

import com.example.lesson3.JPA.model.PersonJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonJPARepository extends CrudRepository <PersonJPA, UUID> {

}
