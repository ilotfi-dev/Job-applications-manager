package com.example.workproject.service;

import com.example.workproject.entity.Skill;
import com.example.workproject.repository.SkillRepository;
import com.example.workproject.util.exception.SkillNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill saveSkill(Skill skill) {
        Skill newSkill = new Skill();
        newSkill.setSkillName(skill.getSkillName());
        return skillRepository.save(newSkill);
    }

    public Skill changeSkill(Long id, Skill skill) {
        Skill updatedSkill = skillRepository.findById(id).orElseThrow(SkillNotFoundException::new);
        updatedSkill.setSkillName(skill.getSkillName());
        return skillRepository.save(updatedSkill);
    }

    public List<Skill> showSkills() {
        return skillRepository.findAll();
    }

    public Skill showSkill(Long id) {
        return skillRepository.findSkillBySkillId(id).orElseThrow(SkillNotFoundException::new);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
