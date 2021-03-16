package com.sapient.exercise.manager;

import com.sapient.exercise.domain.quiz.Quiz;
import com.sapient.exercise.domain.quiz.QuizCategoryQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class QuizManager {

    @Autowired
    MovieManager movieManager;

    @Autowired
    EntertainmentManager entertainmentManager;

    public Quiz fetchQuiz() throws Throwable{
        Quiz quiz = new Quiz();
        CompletableFuture<QuizCategoryQuestions> movieCategoryQuestions = movieManager.findMovieCategoryQuestions(5, 11);
        CompletableFuture<QuizCategoryQuestions> entertainmentCategoryQuestions = entertainmentManager.findEntertainmentCategoryQuestions(5, 12);
        CompletableFuture.allOf(movieCategoryQuestions
                        .thenAccept(x -> quiz.getQuiz().add(x)),
                entertainmentCategoryQuestions
                        .thenAccept(y -> quiz.getQuiz().add(y))).join();
        return quiz;
    }
}
