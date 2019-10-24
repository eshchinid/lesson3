package com.example.lesson3.ThymeLeaf.controller;

import com.example.lesson3.ThymeLeaf.model.PersonTL;
import com.example.lesson3.ThymeLeaf.service.PersonTLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tl")
public class PersonTLCOntroller {

    private final PersonTLService personService;

    @Autowired
    public PersonTLCOntroller(PersonTLService personService) {
        this.personService = personService;
    }

    @GetMapping("/greeting")
    public String homePage(Model model) {
        model.addAttribute("person", new PersonTL());
        return "greeting";
    }

    @PostMapping("/person")
    public String addPagePerson(@ModelAttribute PersonTL person, Model model) {
        personService.createPerson(person);
        model.addAttribute("persons", personService.getAllPersons());
        return "result";
    }
}
