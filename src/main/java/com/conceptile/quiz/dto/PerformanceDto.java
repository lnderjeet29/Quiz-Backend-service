package com.conceptile.quiz.dto;

import com.conceptile.quiz.model.AnswerSubmission;
import com.conceptile.quiz.model.Question;
import com.conceptile.quiz.model.QuizSession;

import java.util.List;
import java.util.Optional;

public class PerformanceDto {
    List<AnswerSubmission> answerSubmissionList;
    Optional<QuizSession> quizSession;
    int totalQuestionAttempt;

    public int getTotalQuestionAttempt() {
        return totalQuestionAttempt;
    }

    public void setTotalQuestionAttempt(int totalQuestionAttempt) {
        this.totalQuestionAttempt = totalQuestionAttempt;
    }

    List<Question> questionList;

    public List<AnswerSubmission> getAnswerSubmissionList() {
        return answerSubmissionList;
    }

    public void setAnswerSubmissionList(List<AnswerSubmission> answerSubmissionList) {
        this.answerSubmissionList = answerSubmissionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Optional<QuizSession> getQuizSession() {
        return quizSession;
    }

    public void setQuizSession(Optional<QuizSession> quizSession) {
        this.quizSession = quizSession;
    }

    public PerformanceDto(List<AnswerSubmission> answerSubmissionList, Optional<QuizSession> quizSession, int totalQuestionAttempt, List<Question> questionList) {
        this.answerSubmissionList = answerSubmissionList;
        this.quizSession = quizSession;
        this.totalQuestionAttempt = totalQuestionAttempt;
        this.questionList = questionList;
    }
}
