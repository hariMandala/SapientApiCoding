package com.sapient.exercise.exceptionhandler;

import com.sapient.exercise.domain.error.QuizError;
import com.sapient.exercise.exception.EntertainmentServiceException;
import com.sapient.exercise.exception.MovieServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class QuizControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MovieServiceException.class)
    ResponseEntity<QuizError> handleMovieServiceException(MovieServiceException ex) {
        return new ResponseEntity<>(new QuizError(ex.getStatusCode().value(),
                            ex.getStatusCode().getReasonPhrase(), ex.getErrorMessage()), ex.getStatusCode());
    }

    @ExceptionHandler(value = EntertainmentServiceException.class)
    ResponseEntity<QuizError> handleEntertainmentServiceException(EntertainmentServiceException ex) {
        return new ResponseEntity<>(new QuizError(ex.getStatusCode().value(),
                ex.getStatusCode().getReasonPhrase(), ex.getErrorMessage()), ex.getStatusCode());
    }

    @ExceptionHandler(value = Throwable.class)
    ResponseEntity<QuizError> handleThrowable(Throwable ex) {
        return new ResponseEntity<>(new QuizError(500,
                "Internal Server Error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
