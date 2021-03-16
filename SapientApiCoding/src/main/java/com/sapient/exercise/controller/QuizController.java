package com.sapient.exercise.controller;

import com.sapient.exercise.domain.quiz.Quiz;
import com.sapient.exercise.manager.QuizManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding/exercise/quiz")
public class QuizController {

    @Autowired
    QuizManager quizManager;

    @GetMapping
    public Quiz getQuiz() throws Throwable {
        return quizManager.fetchQuiz();
    }
}
