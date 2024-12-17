package com.conceptile.quiz.config;

import com.conceptile.quiz.services.QuizService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner loadData(QuizService quizService) {
        return args -> {
            // Create and save 5 questions using the service method

            quizService.createQuestion(
                    "What is the capital of Java?",
                    "Paris", "New York", "London", "None of the above", "d"
            );

            quizService.createQuestion(
                    "What does JVM stand for?",
                    "Java Virtual Machine", "Java Visual Machine", "Java Virtual Macro", "None of the above", "a"
            );

            quizService.createQuestion(
                    "What is the size of the int data type in Java?",
                    "2 bytes", "4 bytes", "8 bytes", "1 byte", "b"
            );

            quizService.createQuestion(
                    "Which of these is a feature of Java?",
                    "Platform-dependent", "Platform-independent", "Non-portable", "None of the above", "b"
            );

            quizService.createQuestion(
                    "What is the default value of a boolean variable in Java?",
                    "true", "false", "0", "null", "b"
            );
        };
    }
}