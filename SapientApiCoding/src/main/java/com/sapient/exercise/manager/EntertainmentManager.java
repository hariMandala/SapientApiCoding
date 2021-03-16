package com.sapient.exercise.manager;

import com.sapient.exercise.domain.entertainment.EntertainmentQuestionsList;
import com.sapient.exercise.domain.quiz.QuizCategoryQuestions;
import com.sapient.exercise.domain.quiz.QuizQuestion;
import com.sapient.exercise.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EntertainmentManager {

    @Autowired
    EntertainmentService entertainmentService;

    public CompletableFuture<QuizCategoryQuestions> findEntertainmentCategoryQuestions(Integer limit, Integer category){
        QuizCategoryQuestions quizCategoryQuestions = new QuizCategoryQuestions();
        EntertainmentQuestionsList entertainmentQuestionsList = entertainmentService.findEntertainmentCategoryQuestions(limit, category);
        if(entertainmentQuestionsList != null) {
            quizCategoryQuestions.setCategory(entertainmentQuestionsList.getResults().size() > 0 ?
                    entertainmentQuestionsList.getResults().get(0).getCategory() : "");
            quizCategoryQuestions
                    .setResults(entertainmentQuestionsList.getResults().stream()
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
