package com.sapient.exercise.service;

import com.sapient.exercise.domain.entertainment.EntertainmentQuestionsList;
import com.sapient.exercise.exception.EntertainmentServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class EntertainmentService {
    private static final Logger logger = LoggerFactory.getLogger(EntertainmentService.class);

    private final RestTemplate restTemplate;

    public EntertainmentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public EntertainmentQuestionsList findEntertainmentCategoryQuestions (Integer limit, Integer category) throws EntertainmentServiceException{
        logger.info("calling Entertainments rest service");
        String url = String.format("https://opentdb.com/api.php/?amount=%d&category=%d", limit,category);
        try {
            return restTemplate.getForObject(url, EntertainmentQuestionsList.class);
        } catch(HttpClientErrorException | HttpServerErrorException hce){
            throw new EntertainmentServiceException(hce.getStatusCode(), hce.getResponseBodyAsString());
        }
    }
}
