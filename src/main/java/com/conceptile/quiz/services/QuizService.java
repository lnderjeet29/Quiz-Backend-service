package com.conceptile.quiz.services;

import com.conceptile.quiz.dto.PerformanceDto;
import com.conceptile.quiz.dto.QuestionReponseDto;
import com.conceptile.quiz.model.Question;

import java.util.List;

public interface QuizService {
    Question createQuestion(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption);

    Long startNewQuizSession(String userId);

    Boolean checkSessionID(Long sessionsId);

    List<QuestionReponseDto> getRandomQuestion();

    void submitAnswer(Long quizSessionId, Long questionId, String selectedOption);

    PerformanceDto getUserPerformance(Long quizSessionId);
}
