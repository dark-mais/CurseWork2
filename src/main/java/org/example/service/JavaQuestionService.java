package org.example.service;

import org.example.model.Question;
import org.example.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("javaQuestionService")
public class JavaQuestionService implements QuestionService {

    private QuestionRepository questionRepository;

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return questionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> allQuestions = getAll();
        if (allQuestions.isEmpty()) {
            return null;
        }
        int randomIndex = new Random().nextInt(allQuestions.size());
        int currentIndex = 0;
        for (Question question : allQuestions) {
            if (currentIndex == randomIndex) {
                return question;
            }
            currentIndex++;
        }
        return null; // Вернуть null в случае непредвиденной ситуации
    }
}
