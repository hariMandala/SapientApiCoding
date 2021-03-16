package com.sapient.exercise.domain.quiz;

import java.util.List;

public class QuizCategoryQuestions {
    private String category;
    private List<QuizQuestion> results;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<QuizQuestion> getResults() {
        return results;
    }

    public void setResults(List<QuizQuestion> results) {
        this.results = results;
    }
}
