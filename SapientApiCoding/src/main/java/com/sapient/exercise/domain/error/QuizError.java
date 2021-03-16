package com.sapient.exercise.domain.error;

public class QuizError {

    private int httpStatus;
    private String httpStatusText;
    private String actualErrorMessage;

    public QuizError(int httpStatus, String httpStatusText, String actualErrorMessage) {
        this.httpStatus = httpStatus;
        this.httpStatusText = httpStatusText;
        this.actualErrorMessage = actualErrorMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getHttpStatusText() {
        return httpStatusText;
    }

    public void setHttpStatusText(String httpStatusText) {
        this.httpStatusText = httpStatusText;
    }

    public String getActualErrorMessage() {
        return actualErrorMessage;
    }

    public void setActualErrorMessage(String actualErrorMessage) {
        this.actualErrorMessage = actualErrorMessage;
    }
}