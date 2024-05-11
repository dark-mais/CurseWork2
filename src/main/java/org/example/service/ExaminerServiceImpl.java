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
        Set<Question> uniqueQuestions = new HashSet<>();
        Random random = new Random();

        while (uniqueQuestions.size() <= amount) {
            for (QuestionService questionService : questionServices) {

                if (random.nextBoolean()) {
                    uniqueQuestions.add(questionService.getRandomQuestion());
                }
            }
        }

        if (amount <= 0) {
            throw new BadRequestException("Requested amount exceeds available questions.");
        }

        return uniqueQuestions;
    }
}
