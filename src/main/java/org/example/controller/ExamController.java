package org.example.controller;

import org.example.model.Question;
import org.example.service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/getQuestions/{amount}")
    public ResponseEntity<Collection<Question>> getQuestions(@PathVariable int amount) {
        Collection<Question> questions = examinerService.getQuestions(amount);
        return ResponseEntity.ok(questions);
    }
}
