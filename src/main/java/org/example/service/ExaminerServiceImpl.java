package org.example.service;

import org.example.exception.BadRequestException;
import org.example.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;

    @Autowired
    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount <= 0) {
            throw new BadRequestException("Requested amount exceeds available questions.");
        }

        Set<Question> uniqueQuestions = new HashSet<>();
        Random random = new Random();

        QuestionService java = questionServices.stream()
                .filter(i -> i instanceof JavaQuestionService)
                .findFirst()
                .get();

        QuestionService math = questionServices.stream()
                .filter(i -> i instanceof MathQuestionService)
                .findFirst()
                .get();

        while (uniqueQuestions.size() <= amount) {

            if (random.nextBoolean()) {
                uniqueQuestions.add(java.getRandomQuestion());
            } else {
                uniqueQuestions.add(math.getRandomQuestion());
            }
        }


        return uniqueQuestions;
    }
}
