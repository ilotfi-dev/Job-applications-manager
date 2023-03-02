package com.example.workproject.controller;

import com.example.workproject.entity.Skill;
import com.example.workproject.service.SkillService;
import com.example.workproject.util.SkillErrorResponse;
import com.example.workproject.util.exception.SkillNotCreatedException;
import com.example.workproject.util.exception.SkillNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public ResponseEntity<Skill> addSkill(@RequestBody @Valid Skill skill,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new SkillNotCreatedException(errorMsg.toString());
        }

        return new ResponseEntity<>(skillService.saveSkill(skill), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> removeSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Skill> changeSkill(@PathVariable Long id, @RequestBody Skill skill) {
        return new ResponseEntity<>(skillService.changeSkill(id, skill), HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SkillErrorResponse> handleException(SkillNotFoundException e) {
        SkillErrorResponse response = new SkillErrorResponse(
                "Skill with this id not found!",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<SkillErrorResponse> handleException(SkillNotCreatedException e) {
        SkillErrorResponse response = new SkillErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
