package com.example.workproject.service;

import com.example.workproject.entity.PersonSkills;
import com.example.workproject.repository.PersonSkillsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonSkillsService {
    private final PersonSkillsRepository personSkillsRepository;

    public PersonSkillsService(PersonSkillsRepository personSkillsRepository) {
        this.personSkillsRepository = personSkillsRepository;
    }

    public List<PersonSkills> showPersonSkills() {
        return personSkillsRepository.findAll();
    }
}
