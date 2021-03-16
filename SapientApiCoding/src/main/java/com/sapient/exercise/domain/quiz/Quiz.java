package com.sapient.exercise.domain.quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<QuizCategoryQuestions> quiz;

    public Quiz(){
        this.quiz = new ArrayList<>();
    }

    public Quiz(List<QuizCategoryQuestions> quiz){
        this.quiz = quiz;
    }

    public List<QuizCategoryQuestions> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<QuizCategoryQuestions> quiz) {
        this.quiz = quiz;
    }
}
