package com.example.workproject.service;

import com.example.workproject.entity.Person;
import com.example.workproject.entity.PersonSkills;
import com.example.workproject.entity.Skill;
import com.example.workproject.repository.PersonRepository;
import com.example.workproject.repository.PersonSkillsRepository;
import com.example.workproject.util.PersonSkillsKey;
import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonSkillsRepository personSkillsRepository;
    private final SkillService skillService;
    @Autowired
    public PersonService(PersonRepository personRepository, PersonSkillsRepository personSkillsRepository, SkillService skillService) {
        this.personRepository = personRepository;
        this.personSkillsRepository = personSkillsRepository;
        this.skillService = skillService;
    }
    @Transactional
    public Person savePerson(Person person){
        Person newPerson = new Person();
        newPerson.setPersonName(person.getPersonName());
        newPerson.setPersonMail(person.getPersonMail());
        newPerson.setPersonDateOfBirth(person.getPersonDateOfBirth());
        newPerson.setPersonCreatedAt(new Date());
        newPerson.getPersonSkills().addAll(person.getPersonSkills()
              .stream()
              .map(personSkills -> {
                  Skill skill = skillService.showSkill(personSkills.getSkill().getSkillId());
                  PersonSkills newPersonSkills = new PersonSkills();
                  PersonSkillsKey key = new PersonSkillsKey();
                  key.setPersonId(newPerson.getPersonId());
                  key.setSkillId(skill.getSkillId());
                  newPersonSkills.setId(key);
                  newPersonSkills.setPerson(newPerson);
                  newPersonSkills.setSkill(skill);
                  newPersonSkills.setRank(personSkills.getRank());
                  newPersonSkills.setNote(personSkills.getNote());
                  return newPersonSkills;
              }).toList()
        );
        return personRepository.save(newPerson);
    }

    public List<PersonSkills> showPersonDetail(Long id){
        Person person = personRepository.findById(id).orElse(null);
        return personSkillsRepository.findAllByPerson(person);
    }
    public List<Person> showPeople(){
        return personRepository.findAll();
    }
}
