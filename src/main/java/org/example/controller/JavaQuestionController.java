package org.example.controller;

import org.example.model.Question;
import org.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier ("javaQuestionService") QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestParam(value = "question", required = false) String question,
                                                @RequestParam(value = "answer", required = false) String answer) {
        Question addedQuestion = javaQuestionService.add(question, answer);
        return ResponseEntity.ok(addedQuestion);
    }

    @GetMapping("/addQuestionObject")
    public ResponseEntity<Question> addQuestionObject(@RequestBody Question question) {
        Question addedQuestion = javaQuestionService.add(question);
        return ResponseEntity.ok(addedQuestion);
    }

    @GetMapping("/remove")
    public ResponseEntity<Question> removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question removedQuestion = javaQuestionService.remove(new Question(question, answer));
        return ResponseEntity.ok(removedQuestion);
    }

    @GetMapping
    public ResponseEntity<Collection<Question>> getAllQuestions() {
        Collection<Question> questions = javaQuestionService.getAll();
        return ResponseEntity.ok(questions);
    }
}
