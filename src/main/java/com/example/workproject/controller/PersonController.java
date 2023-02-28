package com.example.workproject.controller;

import com.example.workproject.entity.Person;
import com.example.workproject.entity.PersonSkills;
import com.example.workproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/")
    public List<Person> people(){
        return personService.showPeople();
    }

    @GetMapping("/{id}")
    public List<PersonSkills> personDetail(@PathVariable Long id){
        return personService.showPersonDetail(id);
    }

}
