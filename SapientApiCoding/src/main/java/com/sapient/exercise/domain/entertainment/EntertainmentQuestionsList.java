package com.sapient.exercise.domain.entertainment;

import com.sapient.exercise.domain.movies.MoviesQuestion;

import java.util.List;

public class EntertainmentQuestionsList {
    Integer response_code;
    List<MoviesQuestion> results;

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }

    public List<MoviesQuestion> getResults() {
        return results;
    }

    public void setResults(List<MoviesQuestion> results) {
        this.results = results;
    }
}
