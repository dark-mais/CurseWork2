package service;

import org.example.model.Question;
import org.example.repository.JavaQuestionRepository;
import org.example.repository.QuestionRepository;
import org.example.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;
    private QuestionRepository questionRepositoryMock;

    @BeforeEach
    void setUp() {
        questionRepositoryMock = mock(JavaQuestionRepository.class);
        javaQuestionService = new JavaQuestionService(questionRepositoryMock);
    }

    @Test
    void addQuestion_Success() {
        Question question = new Question("Test Question", "Test Answer");
        when(questionRepositoryMock.add(question)).thenReturn(question);

        Question addedQuestion = javaQuestionService.add(question);

        assertEquals(question, addedQuestion);
        verify(questionRepositoryMock, times(1)).add(question);
    }

    @Test
    void removeQuestion_Success() {
        Question question = new Question("Test Question", "Test Answer");
        when(questionRepositoryMock.remove(question)).thenReturn(question);

        Question removedQuestion = javaQuestionService.remove(question);

        assertEquals(question, removedQuestion);
        verify(questionRepositoryMock, times(1)).remove(question);
    }

    @Test
    void getAllQuestions_Success() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");
        when(questionRepositoryMock.getAll()).thenReturn(Arrays.asList(question1, question2));

        Collection<Question> allQuestions = javaQuestionService.getAll();

        assertEquals(2, allQuestions.size());
        verify(questionRepositoryMock, times(1)).getAll();
    }
}
