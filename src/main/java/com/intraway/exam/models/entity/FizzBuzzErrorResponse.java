package com.intraway.exam.models.entity;

public class FizzBuzzErrorResponse  {

    private long timeStamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;


    public FizzBuzzErrorResponse() {
    }

    public FizzBuzzErrorResponse(long timeStamp, int status, String error, String exception, String message, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        exception = exception.replace("class ","");
        this.exception = exception;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
