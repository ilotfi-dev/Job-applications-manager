package com.example.workproject.service;

import com.example.workproject.entity.Skill;
import com.example.workproject.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> showSkills(){
        return skillRepository.findAll();
    }
}
