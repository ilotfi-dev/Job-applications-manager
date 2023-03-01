package com.example.workproject.service;

import com.example.workproject.entity.Person;
import com.example.workproject.entity.PersonSkills;
import com.example.workproject.entity.Skill;
import com.example.workproject.repository.PersonRepository;
import com.example.workproject.repository.PersonSkillsRepository;
import com.example.workproject.util.PersonSkillsKey;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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
    public Person savePerson(Person person) {
        Person newPerson = new Person();
        newPerson.setPersonName(person.getPersonName());
        newPerson.setPersonMail(person.getPersonMail());
        newPerson.setPersonDateOfBirth(person.getPersonDateOfBirth());
        newPerson.setPersonCreatedAt(new Date());
        newPerson.getPersonSkills().addAll(setAllSkills(person.getPersonSkills(), newPerson));
        return personRepository.save(newPerson);
    }

    public Person addSkills(Long id, List<PersonSkills> personSkills) {
        Person updatedPerson = personRepository.findById(id).orElse(null);
        updatedPerson.getPersonSkills().addAll(setAllSkills(personSkills, updatedPerson));
        return personRepository.save(updatedPerson);
    }

    public List<PersonSkills> showPersonDetail(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return personSkillsRepository.findAllByPerson(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> showPeople() {
        return personRepository.findAll();
    }

    private List<PersonSkills> setAllSkills(List<PersonSkills> personSkills, Person person) {
        return personSkills
                .stream()
                .map(personSkill -> {
                    Skill skill = skillService.showSkill(personSkill.getSkill().getSkillId());
                    PersonSkills newPersonSkills = new PersonSkills();
                    PersonSkillsKey key = new PersonSkillsKey();
                    key.setPersonId(person.getPersonId());
                    key.setSkillId(skill.getSkillId());
                    newPersonSkills.setId(key);
                    newPersonSkills.setPerson(person);
                    newPersonSkills.setSkill(skill);
                    newPersonSkills.setRank(personSkill.getRank());
                    newPersonSkills.setNote(personSkill.getNote());
                    return newPersonSkills;
                }).toList();
    }
}
