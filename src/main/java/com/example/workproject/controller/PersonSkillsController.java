package com.example.workproject.controller;

import com.example.workproject.entity.PersonSkills;
import com.example.workproject.service.PersonSkillsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonSkillsController {
    private final PersonSkillsService personSkillsService;

    public PersonSkillsController(PersonSkillsService personSkillsService) {
        this.personSkillsService = personSkillsService;
    }

    @GetMapping("/home")
    public List<PersonSkills> personSkillsList() {
        return personSkillsService.showPersonSkills();
    }
}
