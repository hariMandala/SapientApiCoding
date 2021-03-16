package com.sapient.exercise.service;

import com.sapient.exercise.domain.movies.MoviesQuestionsList;
import com.sapient.exercise.exception.MovieServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    private final RestTemplate restTemplate;

    public MovieService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public MoviesQuestionsList findMovieCategoryQuestions(Integer limit, Integer category) throws MovieServiceException {
        logger.info("calling Movies rest service");
        String url = String.format("https://opentdb.com/api.php/?amount=%d&category=%d", limit,category);
        try {
            return restTemplate.getForObject(url, MoviesQuestionsList.class);
        } catch(HttpClientErrorException | HttpServerErrorException hce){
            throw new MovieServiceException(hce.getStatusCode(), hce.getResponseBodyAsString());
        }
    }
}
