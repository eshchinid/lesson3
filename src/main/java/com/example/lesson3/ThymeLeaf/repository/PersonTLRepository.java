package com.example.lesson3.ThymeLeaf.repository;

import com.example.lesson3.ThymeLeaf.model.PersonTL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonTLRepository extends JpaRepository<PersonTL, Long> {

}
