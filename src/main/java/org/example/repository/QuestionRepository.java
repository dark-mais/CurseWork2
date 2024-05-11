package org.example.repository;

import org.example.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
