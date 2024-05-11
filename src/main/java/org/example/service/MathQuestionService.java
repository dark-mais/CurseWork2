package org.example.service;

import org.example.exception.MethodNotAllowedException;
import org.example.model.Question;
import org.example.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("mathQuestionService")
public class MathQuestionService implements QuestionService {

    private QuestionRepository questionRepository;

    public MathQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Method Not Allowed");
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException("Method Not Allowed");
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException("Method Not Allowed");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Method Not Allowed");
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);
        String question = num1 + " + " + num2 + " = ?";
        String answer = String.valueOf(num1 + num2);
        return new Question(question, answer);
    }
}
