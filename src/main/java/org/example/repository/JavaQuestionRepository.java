package org.example.repository;

import jakarta.annotation.PostConstruct;
import org.example.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {
        questions.addAll(List.of(
                new Question("javaQuestion1", "javaAnswer1"),
                new Question("javaQuestion2", "javaAnswer2"),
                new Question("javaQuestion3", "javaAnswer3"),
                new Question("javaQuestion4", "javaAnswer4"),
                new Question("javaQuestion5", "javaAnswer5"),
                new Question("javaQuestion6", "javaAnswer6")
        ));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
