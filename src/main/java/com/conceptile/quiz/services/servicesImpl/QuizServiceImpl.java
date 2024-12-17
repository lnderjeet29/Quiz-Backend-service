package com.conceptile.quiz.services.servicesImpl;

import com.conceptile.quiz.dto.PerformanceDto;
import com.conceptile.quiz.dto.QuestionReponseDto;
import com.conceptile.quiz.model.AnswerSubmission;
import com.conceptile.quiz.model.Question;
import com.conceptile.quiz.model.QuizSession;
import com.conceptile.quiz.repository.AnswerSubmissionRepository;
import com.conceptile.quiz.repository.QuestionRepository;
import com.conceptile.quiz.repository.QuizSessionRepository;
import com.conceptile.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerSubmissionRepository answerSubmissionRepository;

    // Save a new question with options
    @Override
    public Question createQuestion(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        Question question = new Question();
        question.setQuestionText(questionText);
        question.setOptionA(optionA);
        question.setOptionB(optionB);
        question.setOptionC(optionC);
        question.setOptionD(optionD);
        question.setCorrectAnswer(correctOption);

        return questionRepository.save(question);
    }

    // Start a new quiz session
    @Override
    public Long startNewQuizSession(String userId) {
        QuizSession quizSession = new QuizSession();
        quizSession.setUserId(userId);
        int totalQuestions = (int) questionRepository.count();
        quizSession.setTotalQuestions(totalQuestions);
        quizSession.setCorrectAnswers(0);
        quizSessionRepository.save(quizSession);
        return quizSession.getId();
    }

    // Get a random question
    @Override
    public List<QuestionReponseDto> getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        Collections.shuffle(questions);
        List<QuestionReponseDto> response= new ArrayList<>();
        for(Question q:questions){
            QuestionReponseDto reponseDto=new QuestionReponseDto(
                    q.getId(),
                    q.getQuestionText(),
                    q.getOptionA(),
                    q.getOptionB(),
                    q.getOptionC(),
                    q.getOptionD()
            );
            response.add(reponseDto);
        }
        return response;
    }

    public Boolean checkSessionID(Long sessionsId) {
        return quizSessionRepository.findById(sessionsId).isPresent();
    }

    // Submit an answer and update the score
    @Override
    public void submitAnswer(Long quizSessionId, Long questionId, String selectedOption) {
        Optional<QuizSession> quizSessionOpt = quizSessionRepository.findById(quizSessionId);
        Optional<Question> questionOpt = questionRepository.findById(questionId);

        if (quizSessionOpt.isPresent() && questionOpt.isPresent()) {
            QuizSession quizSession = quizSessionOpt.get();
            Question question = questionOpt.get();
            boolean isCorrect = question.getCorrectAnswer().equals(selectedOption);

            AnswerSubmission answerSubmission = new AnswerSubmission();
            answerSubmission.setQuizSessionId(quizSessionId);
            answerSubmission.setQuestionId(questionId);
            answerSubmission.setSelectedOption(selectedOption);
            answerSubmission.setCorrect(isCorrect);
            answerSubmissionRepository.save(answerSubmission);

            // Update quiz session stats
            quizSession.setTotalQuestions(quizSession.getTotalQuestions() + 1);
            if (isCorrect) {
                quizSession.setCorrectAnswers(quizSession.getCorrectAnswers() + 1);
            }
            quizSessionRepository.save(quizSession);
        }
    }

    // Get the total questions answered by user with details
    @Override
    public PerformanceDto getUserPerformance(Long quizSessionId) {
        List<AnswerSubmission> answer=answerSubmissionRepository.findByQuizSessionId(quizSessionId);
        int correct_answer=0;
        int total_question_Attempt=0;
        for(AnswerSubmission ans:answer){
            if(ans.isCorrect())
                correct_answer++;
            total_question_Attempt++;
        }
        Optional<QuizSession> quizSession = quizSessionRepository.findById(quizSessionId);
        if(quizSession.isPresent()){
            quizSession.get().setCorrectAnswers(correct_answer);
        }
        return new PerformanceDto(
                answer,
                quizSession,
                total_question_Attempt,
                questionRepository.findAll()
        );
    }
}
