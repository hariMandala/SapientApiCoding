package com.sapient.exercise.manager;

import com.sapient.exercise.domain.movies.MoviesQuestionsList;
import com.sapient.exercise.domain.quiz.QuizCategoryQuestions;
import com.sapient.exercise.domain.quiz.QuizQuestion;
import com.sapient.exercise.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieManager {

    @Autowired
    MovieService movieService;

    public CompletableFuture<QuizCategoryQuestions> findMovieCategoryQuestions(Integer limit, Integer category) {

        QuizCategoryQuestions quizCategoryQuestions = new QuizCategoryQuestions();
        MoviesQuestionsList moviesQuestionsList = movieService.findMovieCategoryQuestions(limit, category);
        if (moviesQuestionsList != null) {
            quizCategoryQuestions.setCategory(moviesQuestionsList.getResults().size() > 0 ?
                    moviesQuestionsList.getResults().get(0).getCategory() : "");
            quizCategoryQuestions
                    .setResults(moviesQuestionsList.getResults().stream()
                            .map(e -> {
                                QuizQuestion quizQuestion = new QuizQuestion();
                                quizQuestion.setType(e.getType());
                                quizQuestion.setDifficulty(e.getDifficulty());
                                quizQuestion.setQuestion(e.getQuestion());
                                quizQuestion.setCorrect_answer(e.getCorrect_answer());
                                Stream<String> ss = Arrays.stream(e.getIncorrect_answers());
                                Stream<String> ns = Stream.concat(ss, Stream.of(e.getCorrect_answer()));
                                List<String> arrList = ns.collect(Collectors.toList());
                                quizQuestion.setAll_answers(arrList.toArray(String[]::new));
                                return quizQuestion;
                            }).collect(Collectors.toList()));

        }
        return CompletableFuture.completedFuture(quizCategoryQuestions);
    }
}
