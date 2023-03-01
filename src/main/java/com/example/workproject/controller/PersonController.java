package com.example.workproject.controller;

import com.example.workproject.entity.Person;
import com.example.workproject.entity.PersonSkills;
import com.example.workproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> removePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Person> people() {
        return personService.showPeople();
    }

    @GetMapping("/{id}")
    public List<PersonSkills> personDetail(@PathVariable Long id) {
        return personService.showPersonDetail(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @PutMapping("/addSkills/{id}")
    public ResponseEntity<Object> addSkills(@PathVariable Long id, @RequestBody List<PersonSkills> personSkills) {
        return new ResponseEntity<>(personService.addSkills(id, personSkills), HttpStatus.OK);
    }

}
