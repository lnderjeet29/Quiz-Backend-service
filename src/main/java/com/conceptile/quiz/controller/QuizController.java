package com.conceptile.quiz.controller;

import com.conceptile.quiz.dto.PerformanceDto;
import com.conceptile.quiz.dto.QuestionReponseDto;
import com.conceptile.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Start a new quiz session
    @PostMapping("/start")
    public Long startQuiz(@RequestParam String userId) {
        return quizService.startNewQuizSession(userId);
    }

    // API to get a list of random questions for a user (per session)
    @GetMapping("/questions")
    public ResponseEntity<?> getShuffledQuestions(@RequestParam Long sessionId) {
        if (quizService.checkSessionID(sessionId)) {
            List<QuestionReponseDto> shuffledQuestions = quizService.getRandomQuestion();
            return ResponseEntity.ok(shuffledQuestions);
        } else {
            return ResponseEntity.status(404).body(new RuntimeException("User or session not found."));
        }
    }

    // Submit an answer
    @PostMapping("/answer")
    public void submitAnswer(@RequestParam Long quizSessionId, @RequestParam Long questionId, @RequestParam String selectedOption) {
        quizService.submitAnswer(quizSessionId, questionId, selectedOption);
    }

    // Get the total questions answered by user with details
    @GetMapping("/performance")
    public PerformanceDto getUserPerformance(@RequestParam Long quizSessionId) {
        return quizService.getUserPerformance(quizSessionId);
    }
}
