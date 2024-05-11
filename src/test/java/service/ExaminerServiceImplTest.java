package service;

import org.example.model.Question;
import org.example.service.ExaminerServiceImpl;
import org.example.service.JavaQuestionService;
import org.example.service.MathQuestionService;
import org.example.service.QuestionService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    private Collection<QuestionService> questionServices;

    @BeforeEach
    void setUp() {
        questionServices = new ArrayList<>();
        examinerService = new ExaminerServiceImpl((List<QuestionService>) questionServices);
    }

    @Test
    public void getQuestions_Success() {
        Question javaQuestion1 = new Question("Java Question 1", "Java Answer 1");
        Question javaQuestion2 = new Question("Java Question 2", "Java Answer 2");
        Question mathQuestion1 = new Question("Math Question 1", "Math Answer 1");

        QuestionService javaQuestionServiceMock = mock(QuestionService.class);
        when(javaQuestionServiceMock.getAll()).thenReturn(List.of(javaQuestion1, javaQuestion2));

        QuestionService mathQuestionServiceMock = mock(QuestionService.class);
        when(mathQuestionServiceMock.getAll()).thenReturn(Collections.singletonList(mathQuestion1));

        questionServices.add(javaQuestionServiceMock);
        questionServices.add(mathQuestionServiceMock);

        Collection<Question> questions = examinerService.getQuestions(3);

        assertEquals(3, questions.size());
    }
}
