package org.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    @GetMapping("/add")
    public ResponseEntity<Void> addQuestion(@RequestParam(value = "question", required = false) String question,
                                            @RequestParam(value = "answer", required = false) String answer) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @GetMapping("/remove")
    public ResponseEntity<Void> removeQuestion(@RequestParam(value = "question", required = false) String question,
                                               @RequestParam(value = "answer", required = false) String answer) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @GetMapping
    public ResponseEntity<Void> getAllQuestions() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
}

