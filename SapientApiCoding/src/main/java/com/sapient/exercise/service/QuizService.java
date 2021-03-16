package com.sapient.exercise.service;

import com.sapient.exercise.domain.quiz.Quiz;
import com.sapient.exercise.domain.quiz.QuizCategoryQuestions;
import com.sapient.exercise.manager.QuizManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizService {
    @Autowired
    private QuizManager quizManager;

    /*public Quiz getQuiz() {
        List<QuizCategoryQuestions> quizCategoryQuestionsList = quizManager.getAllCategoryQuestionsList();
        return new Quiz(quizCategoryQuestionsList);
    }*/
}
