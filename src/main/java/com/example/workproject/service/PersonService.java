package com.example.workproject.service;

import com.example.workproject.entity.Person;
import com.example.workproject.entity.PersonSkills;
import com.example.workproject.repository.PersonRepository;
import com.example.workproject.repository.PersonSkillsRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonSkillsRepository personSkillsRepository;

    public PersonService(PersonRepository personRepository, PersonSkillsRepository personSkillsRepository) {
        this.personRepository = personRepository;
        this.personSkillsRepository = personSkillsRepository;
    }

    public List<PersonSkills> showPersonDetail(Long id){
        Person person = personRepository.findById(id).orElse(null);
        return personSkillsRepository.findAllByPerson(person);
    }
    public List<Person> showPeople(){
        return personRepository.findAll();
    }
}
