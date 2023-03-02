package com.example.workproject.repository;

import com.example.workproject.entity.Person;
import com.example.workproject.entity.PersonSkills;
import com.example.workproject.util.PersonSkillsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonSkillsRepository extends JpaRepository<PersonSkills, PersonSkillsKey> {
    List<PersonSkills> findAllByPerson(Person person);
}
