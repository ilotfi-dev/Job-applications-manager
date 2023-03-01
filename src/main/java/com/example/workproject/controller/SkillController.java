package com.example.workproject.controller;

import com.example.workproject.entity.Skill;
import com.example.workproject.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/")
    public List<Skill> skills() {
        return skillService.showSkills();
    }

    @GetMapping("/{id}")
    public Skill skillDetail(@PathVariable Long id) {
        return skillService.showSkill(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addSkill(@RequestBody Skill skill) {
        return new ResponseEntity<>(skillService.saveSkill(skill), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> removeSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Object> changeSkill(@PathVariable Long id, @RequestBody Skill skill) {
        return new ResponseEntity<>(skillService.changeSkill(id, skill), HttpStatus.OK);
    }
}
